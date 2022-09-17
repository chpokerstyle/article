package ru.volokitin.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volokitin.article.model.RatingEntity;

public interface RatingRepo extends JpaRepository<RatingEntity, Long> {
}
