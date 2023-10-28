package com.example.lostark_jpa.news.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;

@Getter
@RequiredArgsConstructor
public enum ApiSpec {

    news_notices("/news/notices", HttpMethod.GET),
    news_events("/news/event", HttpMethod.GET);

    private final String endPoint;
    private final HttpMethod httpMethod;

}
