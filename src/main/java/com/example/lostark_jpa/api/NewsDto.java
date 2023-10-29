package com.example.lostark_jpa.api;

import com.example.lostark_jpa.infrastucture.news.entity.News;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

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
                .date(date)
                .title(title)
                .type(type)
                .link(link)
                .build();
    }

}
