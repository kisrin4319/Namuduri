package com.spring.namuduri.repository;

import com.spring.namuduri.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @EntityGraph(attributePaths = {"books"})
    List<Book> findAllByTitle(String title);

    Page<Book> findByTitleContainingOrAuthContainingOrCompanyContaining(String title,String auth,String company,Pageable pageable);

    Page<Book> findByTitleContaining(String title,Pageable pageable);

    Page<Book> findByCategoryContaining(String category,Pageable pageable);

    Page<Book> findByAuthContaining(String title,Pageable pageable);

    Page<Book> findByCompanyContaining(String title,Pageable pageable);

}
