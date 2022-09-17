package ru.volokitin.article.service;

import ru.volokitin.article.model.ArticleEntity;

public interface RatingService {
    boolean ratingS(Long articleId, Integer grade);

    boolean rating(Long articleId, Integer grade);
}
