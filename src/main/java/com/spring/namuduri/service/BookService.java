package com.spring.namuduri.service;

import com.spring.namuduri.model.Book;
import com.spring.namuduri.repository.BookRepository;
import com.spring.namuduri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }
}
