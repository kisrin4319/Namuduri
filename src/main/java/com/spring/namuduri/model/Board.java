package com.spring.namuduri.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 10,message = "제목을 2~8자 사이로 입력해주세요.")
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;
}
