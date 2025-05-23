package com.example.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemoController {

    @Autowired
    private MemoService memoService;

    @GetMapping("/")
    public List<Memo> index() {
        return memoService.findAll();
    }

    @GetMapping("/memo")
    public Memo view_memo(@RequestParam Long id) {
        return memoService.findById(id);
    }

    @PostMapping("/memo/write")
    public Memo write_memo(@RequestBody Memo memo) {
        memoService.save(memo);
        return memoService.findById(memo.getId());
    }
}
