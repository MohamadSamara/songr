package com.example.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CapetalizController {

    @GetMapping("/capitalize/{text}")
    public String capitalize(Model model, @PathVariable String text) {
        String message = text.toUpperCase();
        model.addAttribute("message", message);
        return "upperCase.html";
    }
}
