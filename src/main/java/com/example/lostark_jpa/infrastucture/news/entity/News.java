package com.example.lostark_jpa.infrastucture.news.entity;

import com.example.lostark_jpa.config.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class News extends BaseEntity {
    @Id
    private Long id;
    private String type;

    private LocalDateTime date;
    private String title;
    private String link;

    @Builder
    public News(String type, LocalDateTime date, String title, String link) {
        this.id = Long.parseLong(link.substring(link.lastIndexOf('/') + 1));
        this.type = type;
        this.date = date;
        this.title = title;
        this.link = link;
    }

    public void changeTitle(String newTitle){
        title = newTitle;
    }

}
