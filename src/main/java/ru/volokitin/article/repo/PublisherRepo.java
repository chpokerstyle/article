package ru.volokitin.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.volokitin.article.model.PublisherEntity;

public interface PublisherRepo extends JpaRepository<PublisherEntity, Long> {
}
