package com.example.lostark_jpa.news.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class News {
    @Id
    private Long id;
    private String type;
    private LocalDateTime date;
    private String title;
    private String link;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Builder
    public News(Long id, String type, LocalDateTime date, String title) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.title = title;
    }

}
