package ru.volokitin.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volokitin.article.model.ArticleEntity;

public interface ArticleRepo extends JpaRepository<ArticleEntity, Long> {
}
