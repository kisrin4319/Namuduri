package com.spring.namuduri.service;

import com.spring.namuduri.model.Board;
import com.spring.namuduri.model.User;
import com.spring.namuduri.repository.BoardRepository;
import com.spring.namuduri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username , Board board){

        User user = userRepository.findByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }
}
