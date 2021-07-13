package com.spring.namuduri.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true,name = "user_id")
    private Long userId; //회원 번호

    @Column(nullable = true, name = "book_id")
    private Long bookId; //도서 번호

    private Long count; //장바구니의 상품 수량
    private Long amt; //장바구니의 상품 가격

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User userBasket;
}
