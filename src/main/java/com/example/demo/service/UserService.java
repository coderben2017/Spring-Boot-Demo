package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*
     * 加了事务注解，内部所有操作组成一个逻辑单元
     */
    @Transactional
    public void deleteTwo(Integer id1, Integer id2) {
        userRepository.deleteById(id1);
        userRepository.deleteById(id2)  ;
    }

}
