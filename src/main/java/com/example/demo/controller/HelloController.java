package com.example.demo.controller;

import com.example.demo.model.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String getUser(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "select user where id = " + id;
    }
}
