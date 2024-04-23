package com.example.myBoard.repository;

import com.example.myBoard.entity.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;
    @Test
    @DisplayName("모든 자료 검색")
    void findAllTest(){
        Article article1 = new Article(1L,"가가가","111");
        Article article2 = new Article(2L,"나나나","222");
        Article article3 = new Article(3L,"다다다","333");
        List<Article> expectList = new ArrayList<>();
        expectList.add(article1);
        expectList.add(article2);
        expectList.add(article3);
        List<Article> resultLists =articleRepository.findAll();
        Assertions.assertThat(resultLists.toString()).isEqualTo(expectList.toString());
    }
    @Test
    @DisplayName("실패")
    void wrongTest(){
        Article article1 = new Article(1L,"기기기","111");
        Article article2 = new Article(2L,"니니니","222");
        Article article3 = new Article(3L,"디디디","333");
        List<Article> expectList = new ArrayList<>();
        expectList.add(article1);
        expectList.add(article2);
        expectList.add(article3);
        List<Article> resultLists =articleRepository.findAll();
        Assertions.assertThat(resultLists.toString()).isNotEqualTo(expectList.toString());
    }
    @Test
    void 전체데이터검색개수(){
        int resultCount =3;
        int actualCount = articleRepository.findAll().size();
    }
    @Test
    void 자료입력테스트(){
        Article expectArticle = new Article(4L,"라라라","444");
        Article newArticle = new Article(null,"라라라","444");
        Article acturalArticle = articleRepository.findById(4L).get();
//        assertThat(acturalArticle.toString())
    }
    
}