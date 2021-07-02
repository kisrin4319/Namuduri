package com.spring.namuduri.controller;

import com.spring.namuduri.Service.BoardService;
import com.spring.namuduri.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board/**")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;


    @GetMapping("/list")
    public String List(){
        return "/board/list";
    }

    @GetMapping("/insert")
    public String InsertBoardForm(){
        return "/boards/insert";
    }
    @PostMapping("/insert")
    public String InsertBoard(Board board){
        service.InsertBoard(board);
        return "redirect:/board/main";
    }

    @PutMapping("/update")
    public String updateBoard(Board board){
        service.updateBoard(board);
        return "redirect:/board/main";
    }
    @DeleteMapping("/delete")
    public String deleteBoard(Long boardId){
        service.deleteBoard(boardId);
        return "redirect:/board/main";
    }
}
