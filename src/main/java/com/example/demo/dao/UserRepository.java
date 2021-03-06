package com.example.demo.dao;

import com.example.demo.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 可扩展的JPA仓库
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByAge(Integer age);

}
