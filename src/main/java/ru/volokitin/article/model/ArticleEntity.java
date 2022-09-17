package ru.volokitin.article.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
//    @JoinColumn(nullable = false)
    public PublisherEntity publisherEntity;

//    public ArticleEntity(Long id, String name, String author, String content, Date dateForPublishing) {
//        this.id = id;
//        this.name = name;
//        this.author = author;
//        this.content = content;
//        this.dateForPublishing = dateForPublishing;
//    }
//
//    public ArticleEntity() {
//    }
}
