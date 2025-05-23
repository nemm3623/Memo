package com.example.memo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByTitleContainingOrContentContaining(String title, String content);
    List<Memo> findByTitleContaining(String title);
    List<Memo> findByContentContaining(String content);
}
