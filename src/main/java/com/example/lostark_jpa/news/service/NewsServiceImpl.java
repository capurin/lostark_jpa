package com.example.lostark_jpa.news.service;

import com.example.lostark_jpa.news.api.ApiSpec;
import com.example.lostark_jpa.news.api.LostArkApiConnenctor;
import com.example.lostark_jpa.news.api.LostArkApiRepositoryService;
import com.example.lostark_jpa.news.api.NewsDto;
import com.example.lostark_jpa.news.entity.News;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService{

    private final NewsRepository newsRepository;
    private final LostArkApiRepositoryService apiRepositoryService;

    @Override
    public List<News> findAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public Object getNewsApi() {
        return apiRepositoryService.getApiNotices();
    }

    @Override
    public List<News> saveNewsByApi() {
        List<NewsDto> apiNews = apiRepositoryService.getApiNotices();
        List<News> news = apiNews.stream().map(NewsDto::toEntity).toList();
        return newsRepository.saveAll(news);
    }
}
