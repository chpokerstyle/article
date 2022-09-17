package ru.volokitin.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.volokitin.article.model.ArticleEntity;
import ru.volokitin.article.model.PublisherEntity;
import ru.volokitin.article.service.ArticleService;
import ru.volokitin.article.service.PublisherService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pub")
public class PublisherController {

    @Autowired
    public ArticleService articleService;
    @Autowired
    public PublisherService publisherService;

    @PostMapping("/create/article")
    public ResponseEntity<String> createArticle(@RequestBody ArticleEntity articleEntity) {
        if (articleEntity == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        if (articleEntity.getName().length() < 100)
            return new ResponseEntity<String>("The title should not exceed 100 characters", HttpStatus.CONFLICT);
        articleService.createArticle(articleEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleEntity>> getAllArticles() {
        var listArticle = articleService.getAll()
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return new ResponseEntity<>(listArticle, HttpStatus.OK);
    }

    @PostMapping("create/publisher")
    public ResponseEntity<Void> createPublisher(@RequestBody PublisherEntity publisherEntity) {
        if (publisherEntity == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
