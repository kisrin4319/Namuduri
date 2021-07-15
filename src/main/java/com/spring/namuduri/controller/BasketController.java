package com.spring.namuduri.controller;

import com.spring.namuduri.model.Basket;
import com.spring.namuduri.model.Book;
import com.spring.namuduri.model.User;
import com.spring.namuduri.repository.BasketRepository;
import com.spring.namuduri.repository.BookRepository;
import com.spring.namuduri.repository.UserRepository;
import com.spring.namuduri.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private BasketService basketService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;



    @GetMapping("/list")
    public String List(Model model,Authentication authentication){

        String username = authentication.getName();

        User user = userRepository.findByUsername(username);

        List<Basket> basket = basketRepository.findBasketByUserId(user.getId());
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

    @PostMapping("/form")
    public String postForm(Basket basket){

        Book book = bookRepository.getOne(basket.getBookId());

        //책 가격 * 수정한 장바구니 갯수로 금액 수정
        Long amt = basket.getCount() * book.getPrice();
        basket.setAmt(amt);

        basketService.save(basket);
        return "redirect:/basket/list";
    }

    @PostMapping("/insert")
    public String insertBasket(@ModelAttribute Basket newBasket,Authentication authentication){

        String username = authentication.getName();

        User user = userRepository.findByUsername(username);

        newBasket.setUserId(user.getId());
        basketService.save(newBasket);
        return "redirect:/basket/list";
    }
}
