package com.example.myBoard.Dto;

import com.example.myBoard.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    public Article fromArticleDto(ArticleDto dto){
        Article article = new Article();
        article.setId(dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        return article;
    }

    public static ArticleDto fromQuizEntity(Article article) {
        return new ArticleDto(
                article.getId(),
                article.getTitle(),
                article.getContent()
        );
    }
    public static ArticleDto allOf(Long id, String title, String content){
        return new ArticleDto(id,title,content);
    }
}
