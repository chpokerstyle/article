package ru.volokitin.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.volokitin.article.model.ArticleEntity;
import ru.volokitin.article.service.ArticleService;
import ru.volokitin.article.service.RatingService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adm")
public class AdminController {
    @Autowired
    public ArticleService articleService;
    @Autowired
    public RatingService ratingService;

    @GetMapping("/all")
    public ResponseEntity<List<ArticleEntity>> getAllArticles() {
        var listArticle = articleService.getAll()
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return new ResponseEntity<>(listArticle, HttpStatus.OK);
    }

    @GetMapping("/statistics")
    public ResponseEntity<Long> getStatisticFor7day(){
        var statistic = articleService.statisticFor7day();
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @PostMapping(path = "/rating/{articleId}")
    public ResponseEntity<Void> rating(@PathVariable Long articleId, @RequestBody Integer gradle){
        var boolSave = ratingService.rating(articleId, gradle);
        if (boolSave = false) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
