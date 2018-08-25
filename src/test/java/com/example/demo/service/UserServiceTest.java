package com.example.demo.service;

import com.example.demo.data.User;
import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findOneTest() {
        Integer age = userService.getAgeById(13);
        Assert.assertEquals(new Integer(22), age); // 断言，期望age=22
    }

}
