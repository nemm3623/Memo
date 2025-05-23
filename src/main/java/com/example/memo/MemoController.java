package com.example.memo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
public class MemoController {


    private final MemoService memoService;

    MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/")
    public List<Memo> index() {
        return memoService.findAll();
    }

    @GetMapping("/memo/{id}")
    public Memo view_memo(@PathVariable("id") Long id) {
        return memoService.findById(id);
    }

    @GetMapping("/memo")
    public List<Memo> view_memo(@RequestParam(required = false) String title, @RequestParam(required = false) String content) {
        return memoService.findByTitleOrByContent(title,content);
    }

    @PostMapping("/memo/write")
    public ResponseEntity<?> write_memo(@RequestBody Memo memo) {
        Memo savedMemo = memoService.save(memo);
        return ResponseEntity.created(URI.create("/memo/" + savedMemo.getId())).build();
    }

    @DeleteMapping("/memo/delete/{id}")
    public ResponseEntity<?> delete_memo(@PathVariable("id") Long id) {
        try {
            memoService.delete(id);
            return ResponseEntity.ok("Delete Clear");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
