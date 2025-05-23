package com.example.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    public Memo save(Memo memo) {
        return memoRepository.save(memo);
    }

    public Memo findById(long id) {
        return memoRepository.findById(id).orElse(null);
    }

    public List<Memo> findAll() {
        return memoRepository.findAll();
    }

    public void delete(long id) throws IllegalStateException{
        memoRepository.findById(id).orElseThrow(()
                -> new IllegalStateException("Memo not found"));

        memoRepository.deleteById(id);
    }

    public List<Memo> findByTitleOrByContent(String title, String content) {
        boolean check_title = (title == null || title.trim().isEmpty());
        boolean check_content = (content == null || content.trim().isEmpty());

        if (check_title && check_content)
            return memoRepository.findAll();
        else if (check_title)
            return findByContent(content);
        else if (check_content)
            return findByTitle(title);
        else
            return memoRepository.findByTitleContainingOrContentContaining(title,content);
    }

    public List<Memo> findByTitle(String title) {
        return memoRepository.findByTitleContaining(title);
    }

    public List<Memo> findByContent(String content) {
        return memoRepository.findByContentContaining(content);
    }
}
