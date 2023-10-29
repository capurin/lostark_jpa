package com.example.lostark_jpa.infrastucture.news;

import com.example.lostark_jpa.infrastucture.news.entity.News;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsService {

    List<News> findAllNews();

    Object getNewsApi() throws Exception;

    @Transactional
    List<News> saveNewsByApi();

    @Transactional
    void changeTitle();
}
