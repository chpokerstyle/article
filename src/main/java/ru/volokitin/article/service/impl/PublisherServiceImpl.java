package ru.volokitin.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volokitin.article.model.PublisherEntity;
import ru.volokitin.article.repo.PublisherRepo;
import ru.volokitin.article.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepo publisherRepo;
    @Override
    public void create(PublisherEntity publisherEntity) {
        publisherRepo.save(publisherEntity);
    }
}
