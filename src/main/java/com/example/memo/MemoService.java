package com.example.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;


    public Memo save(Memo memo) {

        if (memo.getId() != null) {
            if (memoRepository.existsById(memo.getId())) {
                return null;
            }
        }
        return memoRepository.save(memo);
    }

    public Memo findById(long id) {
        return memoRepository.findById(id).orElse(null);
    }

    public List<Memo> findAll() {
        return memoRepository.findAll();
    }

    public void delete(long id) {
        memoRepository.deleteById(id);
    }


}
