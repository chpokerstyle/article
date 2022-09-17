package ru.volokitin.article.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Date dateForPublishing;

    @ManyToOne(fetch = FetchType.EAGER)
    public PublisherEntity publisherEntity;

    @OneToMany(mappedBy = "articleEntity")
    public List<RatingEntity> ratingEntityList;
}
