package com.example.lostark_jpa.news.api;

import com.example.lostark_jpa.news.entity.News;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class NewsDto {

    @JsonProperty("Date")
    private LocalDateTime date;
    @JsonProperty("Link")
    private String link;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Type")
    private String type;

    public News toEntity() {
        return News.builder()
                .id(Long.parseLong(link.substring(link.lastIndexOf('/') + 1)))
                .date(date)
                .title(title)
                .type(type)
                .build();
    }

}
