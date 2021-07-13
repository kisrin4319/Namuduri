package com.spring.namuduri.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 리뷰 번호

    @Column(nullable = true,name = "user_id")
    private Long userid; // 회원ID

    @Column(nullable = true,name = "book_id")
    private Long bookId; // 도서 번호

    private String password;	// 리뷰 비밀번호
    private String content;     // 리뷰 내용
    private Date regdate;       //리뷰 등록 날짜



    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id",insertable = false,updatable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id",referencedColumnName = "id",insertable = false,updatable = false)
    @JsonIgnore
    private Book book;
}
