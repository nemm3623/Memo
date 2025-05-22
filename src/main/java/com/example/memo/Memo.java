package com.example.memo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Memo{

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    protected Memo(){}

    public Memo(String title, String content){
        this.title = title;
        this.content = content;
    }
}
