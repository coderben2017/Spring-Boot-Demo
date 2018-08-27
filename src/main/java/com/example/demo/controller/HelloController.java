package com.example.demo.controller;

import com.example.demo.data.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class HelloController {

    private final HelloProperties helloProperties;

    @Autowired
    public HelloController(HelloProperties userProperties) {
        this.helloProperties = userProperties;
    }

    @RequestMapping(value = {"/hello", "hi"}, method = RequestMethod.GET)
    public String sayHello() {
        return "Hello " + helloProperties.getName() +
                "......you are " + helloProperties.getAge() + " years old." +
                "......server use the " + helloProperties.getPort() + " port";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String sayIndex() {
        return "index"; // 没有显示模板啊？？？
    }

    // 简单GET、POST等
    @GetMapping("/hello/user")
    public Object getUser() {
        HelloProperties hello = new HelloProperties();
        hello.setName("hello");
        hello.setBirthday(new Date());
        hello.setDescription(null);
        return hello;
    }

}
