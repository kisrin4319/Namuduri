package com.spring.namuduri.controller;

import com.spring.namuduri.model.Book;
import com.spring.namuduri.model.Review;
import com.spring.namuduri.repository.BookRepository;
import com.spring.namuduri.repository.ReviewRepository;
import com.spring.namuduri.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private ReviewRepository reviewRepository;

    /*
    @Autowired
    private BookValidator bookValidator;
*/

    @GetMapping("/list")
    public String List(Model model,@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false,defaultValue ="") String searchText,
                       @RequestParam(required = false,defaultValue = "") String category, @RequestParam(required = false,defaultValue = "0") String option){
        //Page<Book> books = bookRepository.findAll(pageable);
        Page<Book> books;

        if(category.equals("")) {
            if(option.equals("0")){ //통합
                books = bookRepository.findByTitleContainingOrAuthContainingOrCompanyContaining(searchText,searchText,searchText, pageable);
            } else if(option.equals("1")){ // 제목
                books = bookRepository.findByTitleContaining(searchText, pageable);
            } else if(option.equals("2")){ //저자
                books = bookRepository.findByAuthContaining(searchText, pageable);
            } else { //출판사
                books = bookRepository.findByCompanyContaining(searchText, pageable);
            }

        } else {
            books = bookRepository.findByCategoryContaining(category,pageable);
        }

        int startPage = Math.max(1,books.getPageable().getPageNumber() - 10);
        int endPage   = Math.min(books.getTotalPages(),books.getPageable().getPageNumber() + 10);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("books",books);
        return "book/bookList";
    }


    @GetMapping("/form")
    public String form(Model model,@PageableDefault(size = 10) Pageable pageable,@RequestParam(required = false) Long id){


        if(id == null){
            model.addAttribute("book", new Book());
        } else {
            Book book = bookRepository.findById(id).orElse(null);
            model.addAttribute("book",book);
        }
       // Page<Review> reviews = reviewRepository.findByBook_id(id,pageable);
/*
        int startPage = Math.max(1,reviews.getPageable().getPageNumber() - 10);
        int endPage   = Math.min(reviews.getTotalPages(),reviews.getPageable().getPageNumber() + 10);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("reviews",reviews);*/

        return "/book/bookform";
    }
    @PostMapping("/form")
    public String postForm(@Valid Book book, BindingResult bindingResult, Authentication authentication){
       // bookValidator.validate(book,bindingResult);
        //if(bindingResult.hasErrors() ){
//            return "/book/form";
//        }
        //Authentication a = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        bookService.save(username,book);
        bookService.save(book);

        return "redirect:/book/list";
    }
}
