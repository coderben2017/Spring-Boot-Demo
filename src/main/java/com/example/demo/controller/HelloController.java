package com.example.demo.controller;

import com.example.demo.data.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class HelloController {

    private final Hello hello;

    @Autowired
    public HelloController(Hello hello) {
        this.hello = hello;
    }

    @RequestMapping(value = {"/hello", "hi"}, method = RequestMethod.GET)
    public String sayHello() {
        return "Hello " + hello.getName() +
                "......you are " + hello.getAge() + " years old." +
                "......server use the " + hello.getPort() + " port";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String sayIndex() {
        return "index"; // 没有显示模板啊？？？
    }

    // 简单GET、POST等
    @GetMapping("/hello/user")
    public Object getUser() {
        Hello hello = new Hello();
        hello.setName("hello");
        hello.setBirthday(new Date());
        hello.setDescription(null);
        return hello;
    }

}
