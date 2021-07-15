package com.spring.namuduri.controller;

import com.spring.namuduri.model.Basket;
import com.spring.namuduri.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class BasketApiController {

    @Autowired
    private BasketRepository repository;

   /* @GetMapping("/baskets")
    List<Basket> all(@RequestParam(required = false, defaultValue = "") String title,
                    @RequestParam(required = false, defaultValue = "") String content) {
        if(!StringUtils.hasText(title) && !StringUtils.hasText(content)) {
            return repository.findAll();
        } else {
            //return repository.findByTitle(title);
            return repository.findByTitleOrContent(title,content);
        }
    }*/

    @PostMapping("/baskets")
    Basket newBasket(@RequestBody Basket newBasket) {
        return repository.save(newBasket);
    }

    // Single item

    @GetMapping("/baskets/{id}")
    Basket one(@PathVariable Long id) {

        return repository.findById(id).orElse(null);
    }
/*

    @RequestMapping("/baskets/{id}")
    Basket replaceBasket(@RequestBody Basket newBasket, @PathVariable Long id) {

        System.out.println("test");

        return repository.findById(id)
                .map(basket -> {
                    basket.setAmt(newBasket.getAmt());
                    basket.setCount(newBasket.getCount());
                    return repository.save(basket);
                })
                .orElseGet(() -> {
                    newBasket.setId(id);
                    return repository.save(newBasket);
                });
    }
*/

    @Secured("ROLE_USER")
    @DeleteMapping("/baskets/{id}")
    void deleteBasket(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
