package com.example.demo.controller;

import com.example.demo.model.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserProperties userProperties;

    @Autowired
    public UserController(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello " + userProperties.getName() +
                "......you are " + userProperties.getAge() + " years old." +
                "......server use the " + userProperties.getPort() + " port";
    }

}
