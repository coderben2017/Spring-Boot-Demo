package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.data.User;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 同时删除2个用户
     * 通过事务注解，内部所有操作形成一个逻辑单元
     */
    @Transactional
    public void deleteTwo(Integer id1, Integer id2) {
        userRepository.deleteById(id1);
        userRepository.deleteById(id2)  ;
    }

    public Integer getAgeById(Integer id) throws UserException {
        User user = userRepository.findById(id).get();
        if (user.getAge() > 100) {
            throw new UserException(ResultEnum.AGE_LARGE);
        }
        return user.getAge();
    }

}
