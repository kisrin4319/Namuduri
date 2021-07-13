package com.spring.namuduri.controller;

import com.spring.namuduri.model.Basket;
import com.spring.namuduri.repository.BasketRepository;
import com.spring.namuduri.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private BasketService basketService;

    @GetMapping("/list")
    public String List(Model model, @RequestParam(required = false) Long userId){
        List<Basket> basket = basketRepository.findBasketByUserId(userId);
        model.addAttribute("basket",basket);
        model.addAttribute("size",basket.size());
        return "basket/basketlist";
    }

    @GetMapping("/form")
    public String form(Model model,@RequestParam(required = false) Long id){

        if(id == null){
            model.addAttribute("basket", new Basket());
        } else {
            Basket basket = basketRepository.findById(id).orElse(null);
            model.addAttribute("basket",basket);
        }
        return "/basket/form";
    }
}
