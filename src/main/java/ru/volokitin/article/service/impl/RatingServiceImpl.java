package ru.volokitin.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volokitin.article.model.ArticleEntity;
import ru.volokitin.article.model.RatingEntity;
import ru.volokitin.article.repo.ArticleRepo;
import ru.volokitin.article.repo.RatingRepo;
import ru.volokitin.article.service.RatingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private ArticleRepo articleRepo;
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public boolean ratingS(Long articleId, Integer grade) {
        //Здесь должно быть MongoDB, но у меня очень мало времени...
        Map<String, String> ratingMap = new HashMap<>();
        if (articleRepo.findById(articleId) == null) return false;
        if (10 < grade || 0 > grade) return false;
        ratingMap.put(articleId.toString(), grade.toString());
        return true;
    }

    @Override
    public boolean rating(Long articleId, Integer grade) {
        var article = articleRepo.getReferenceById(articleId);
        if (articleRepo.findById(articleId) != null) {
            if (11 > grade || 0 < grade) {
                ratingRepo.save(new RatingEntity.RatingEntityBuilder()
                        .gradle(grade)
                        .articleEntity(article)
                        .build());
                return true;
            }
        }
        return false;
    }
}
