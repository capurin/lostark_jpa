package com.example.lostark_jpa.news.api;

import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface LostArkApiRepositoryService {

    @GetExchange("/news/notices")
    List<NewsDto> getApiNotices();

}
