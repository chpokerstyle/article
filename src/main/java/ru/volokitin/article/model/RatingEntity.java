package ru.volokitin.article.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table
public class RatingEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int gradle;
    @ManyToOne()
    ArticleEntity articleEntity;

    public RatingEntity() {
    }

    public RatingEntity(Long id, int gradle, ArticleEntity articleEntity) {
        this.id = id;
        this.gradle = gradle;
        this.articleEntity = articleEntity;
    }

    @Override
    public String toString() {
        return "RatingEntity{" +
                "id=" + id +
                ", gradle=" + gradle +
                ", articleEntity=" + articleEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingEntity that = (RatingEntity) o;
        return gradle == that.gradle && Objects.equals(id, that.id) && Objects.equals(articleEntity, that.articleEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gradle, articleEntity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGradle() {
        return gradle;
    }

    public void setGradle(int gradle) {
        this.gradle = gradle;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public static final class RatingEntityBuilder {
        private Long id;
        private int gradle;
        private ArticleEntity articleEntity;

        public RatingEntityBuilder() {
        }

        public static RatingEntityBuilder aRatingEntity() {
            return new RatingEntityBuilder();
        }

        public RatingEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RatingEntityBuilder gradle(int gradle) {
            this.gradle = gradle;
            return this;
        }

        public RatingEntityBuilder articleEntity(ArticleEntity articleEntity) {
            this.articleEntity = articleEntity;
            return this;
        }

        public RatingEntity build() {
            RatingEntity ratingEntity = new RatingEntity();
            ratingEntity.setId(id);
            ratingEntity.setGradle(gradle);
            ratingEntity.setArticleEntity(articleEntity);
            return ratingEntity;
        }
    }
}
