package com.spring.namuduri.service;

import com.spring.namuduri.model.Basket;
import com.spring.namuduri.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public Basket save(Basket basket){
        return basketRepository.save(basket);
    }
}
