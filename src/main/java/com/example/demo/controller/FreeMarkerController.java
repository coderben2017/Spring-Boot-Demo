package com.example.demo.controller;

import com.example.demo.data.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ftl")
public class FreeMarkerController {

    @Autowired
    private Hello hello;

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("hello", hello);
        return "freemarker/index";
    }

    @RequestMapping("index/center")
    public String center() {
        return "freemarker/center/center";
    }

}
