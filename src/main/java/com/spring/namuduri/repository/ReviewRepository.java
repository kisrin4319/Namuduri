package com.spring.namuduri.repository;

import com.spring.namuduri.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @EntityGraph(attributePaths = {"reviews"})
    Page<Review> findByBookId(Long bookId,Pageable pageable);
}
