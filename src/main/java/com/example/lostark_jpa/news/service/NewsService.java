package com.example.lostark_jpa.news.service;

import com.example.lostark_jpa.news.entity.News;

import java.util.List;

public interface NewsService {

    List<News> findAllNews();
}
