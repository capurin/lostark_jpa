package com.example.lostark_jpa.news.service;

import com.example.lostark_jpa.news.entity.News;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsService {

    List<News> findAllNews();

    Object getNewsApi() throws Exception;

    @Transactional
    List<News> saveNewsByApi() ;
}
