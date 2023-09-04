package com.example.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("message" , "hello");
        return "hello.html";
    }

}