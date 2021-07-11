package com.spring.namuduri.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category; // 도서 카테고리
    private String title; // 도서 제목
    private String content; // 도서 내용
    private int price; // 도서 가격
    private String image; //도서 이미지
    private String publish_date; // 도서 출판 날짜
    private Date book_date; // 도서 등록 날짜
    private String company; // 출판사 이름
    private String auth; // 도서 작가
}
