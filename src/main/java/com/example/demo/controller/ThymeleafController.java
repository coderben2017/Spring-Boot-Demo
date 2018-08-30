package com.example.demo.controller;

import com.example.demo.data.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @Autowired
    private Hello hello;

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("hello", hello);
        List<String> list = new ArrayList<>();
        list.add("hahaha");
        list.add("lalala");
        map.addAttribute("list", list);
        return "thymeleaf/index";
    }

    @RequestMapping("index/center")
    public String center() {
        return "thymeleaf/center/center";
    }

}
