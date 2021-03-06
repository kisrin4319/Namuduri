package com.spring.namuduri.controller;

import com.spring.namuduri.model.User;
import com.spring.namuduri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "member/loginForm";
    }

    @GetMapping("/register")
    public String register(){
        return "member/signForm";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        return "redirect:/";
    }

}
