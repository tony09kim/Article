package com.example.myBoard.service;

import com.example.myBoard.Dto.ArticleDto;
import com.example.myBoard.controller.connection.DBConnection;
import com.example.myBoard.entity.Article;
import com.example.myBoard.repository.ArticleRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDto> findAllArticle(){
        List<ArticleDto> articleDtoList = new ArrayList<>();
        return articleRepository.findAll()
                .stream()
                .map(x-> ArticleDto.fromQuizEntity(x))
                .toList();
    }

    public void newArticle(ArticleDto dto){
        Article article = dto.fromArticleDto(dto);
        articleRepository.save(article);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }

    public ArticleDto findOne(Long id){
        Connection conn=DBConnection.getDbConn();
        PreparedStatement psmt =null;
        ResultSet rs =null;
        String sql;
        ArticleDto articleDto= null;
        try {
            sql = "select * from article where id=?";
            psmt= conn.prepareStatement(sql);
            psmt.setLong(1,id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                articleDto= ArticleDto.allOf(
                        rs.getLong("id"),rs.getString("title"),rs.getString("content")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return articleDto;
    }

}
