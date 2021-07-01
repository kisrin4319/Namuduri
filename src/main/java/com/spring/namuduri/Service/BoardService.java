package com.spring.namuduri.Service;

import com.spring.namuduri.domain.Board;
import com.spring.namuduri.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Repository
//@Transactional(readOnly = true) MYSQL 5.6.5버전 이후에서만 지원된다고 해서 주석처리
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardCount(){
        return boardMapper.boardCount();
    }

    public List<Board> boardList(){
        return boardMapper.getList();
    }

    public Board getBoard(Long boardId){
        return boardMapper.getBoard(boardId);
    }

    public void InsertBoard(Board board){
        boardMapper.InsertBoard(board);
    }


}
