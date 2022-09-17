package ru.volokitin.article.rest.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class ArticleDto {
    private Long id;
    private String name;
    private String author;
    private String content;
    private Date dateForPublishing;
}
