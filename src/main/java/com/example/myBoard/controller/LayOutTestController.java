package com.example.myBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayOutTestController {
    @GetMapping("/test")
    public String testView(Model model) {
        model.addAttribute("name", "나");
        return "test";
    }


}
