package com.spring.namuduri.repository;

import com.spring.namuduri.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
