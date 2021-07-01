package com.spring.namuduri.mapper;

import com.spring.namuduri.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    int boardCount();

    List<Board> getList();

    Board getBoard(Long boardId);

    void InsertBoard(Board board);


}
