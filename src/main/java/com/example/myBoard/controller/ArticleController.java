package com.example.myBoard.controller;

import com.example.myBoard.Dto.ArticleDto;
import com.example.myBoard.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ArticleController {
    private ArticleService articleService2;

    public ArticleController(ArticleService articleService2) {
        this.articleService2 = articleService2;
    }
    @GetMapping("insert")
    public String insertArt(Model model){
        ArticleDto dto=new ArticleDto();
        model.addAttribute("ArticleDto",dto);
        return "new";
    }
    @PostMapping("insert")
    public String insertArticle(@ModelAttribute("ArticleDto")ArticleDto dto){
        articleService2.newArticle(dto);
        return "redirect:/";
    }

    @GetMapping("delete")
    public String showDelete(){
        return "deleteForm";
    }
    @PostMapping("delete")
    public String delete(@RequestParam("deleteId")Long id){
        articleService2.deleteArticle(id);
        return "redirect:/";
    }

    @GetMapping("alter")
    public String alter(Model model){
//        ArticleDto dto =new ArticleDto();
//        dto=articleService2.findById(id);
//        model.addAttribute(dto);
        return "alterNum";
    }

    @PostMapping("alter")
    public String alterForm(@RequestParam("alterId")Long id,Model model){
        ArticleDto dto = new ArticleDto();
        ArticleDto dto1 = new ArticleDto();
        ArticleDto articleDto = new ArticleDto();
        dto1= articleService2.findOne(id);
        dto.setId(dto1.getId());
        dto.setTitle(dto1.getTitle());
        dto.setContent(dto1.getContent());
        model.addAttribute("dto",dto);
        model.addAttribute("articleDto",articleDto);
        return "alterForm";
    }
    @PostMapping("alterArticle")
    public String newArticle(@RequestParam("id")Long id, @ModelAttribute("articleDto")ArticleDto dto){
        dto.setId(id);
        articleService2.newArticle(dto);
        log.info(dto.getId()+"id");
        log.info(dto.getTitle());
        log.info(dto.getContent());
        return "redirect:/";
    }
}
