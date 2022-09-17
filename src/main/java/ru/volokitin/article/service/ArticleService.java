package ru.volokitin.article.service;

import ru.volokitin.article.model.ArticleEntity;

import java.util.List;

public interface ArticleService {

    void createArticle(ArticleEntity articleEntity);

    List<ArticleEntity> getAll();

    Long statisticFor7day();

}
