package ru.volokitin.article.model;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "publisherEntity")
//    @JoinColumn(nullable = true)
    List<ArticleEntity> articleEntityList;
}
