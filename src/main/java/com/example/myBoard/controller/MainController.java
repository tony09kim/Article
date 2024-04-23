package com.example.myBoard.controller;

import com.example.myBoard.Dto.ArticleDto;
import com.example.myBoard.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private ArticleService articleService;

    public MainController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String showView(Model model) {
        List<ArticleDto> dtoList = articleService.findAllArticle();
        model.addAttribute("ArticleDto", dtoList);
        return "show_all";
    }

}
