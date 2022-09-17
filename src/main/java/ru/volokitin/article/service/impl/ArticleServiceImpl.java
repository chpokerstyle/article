package ru.volokitin.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volokitin.article.model.ArticleEntity;
import ru.volokitin.article.repo.ArticleRepo;
import ru.volokitin.article.service.ArticleService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public void createArticle(ArticleEntity articleEntity) {
        articleRepo.save(articleEntity);
    }

    @Override
    public List<ArticleEntity> getAll() {
        return articleRepo.findAll();
    }

    @Override
    public Long statisticFor7day() {
        var dateNow = new Date().getTime();
        long sevenDay = 604800000;
        var a = dateNow - sevenDay;
        Date before = new Date(a);
        var elements = articleRepo.findAll()
                .stream()
                .filter(articleEntity ->
                        articleEntity.getDateForPublishing().before(before) &&
                        articleEntity.getDateForPublishing().after(new Date())
                ).count();
        return elements;
    }
}
