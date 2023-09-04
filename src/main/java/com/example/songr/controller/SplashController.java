package com.example.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SplashController {
    @GetMapping("/")
    public String splash(Model model){
        model.addAttribute("message" , "Welcome To Home Page");
        return "splash.html";
    }
}
