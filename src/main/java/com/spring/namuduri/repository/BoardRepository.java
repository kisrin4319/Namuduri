package com.spring.namuduri.repository;

import com.spring.namuduri.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    List<Board> findByTitle(String title);
    List<Board> findByTitleOrContent(String title,String Content);

    Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
