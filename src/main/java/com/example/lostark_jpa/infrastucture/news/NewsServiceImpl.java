package com.example.lostark_jpa.infrastucture.news;

import com.example.lostark_jpa.api.LostArkApiRepositoryService;
import com.example.lostark_jpa.api.NewsDto;
import com.example.lostark_jpa.infrastucture.news.entity.News;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public List<News> saveNewsByApi() {
        List<NewsDto> apiNews = apiRepositoryService.getApiNotices();
        List<News> news = apiNews.stream().map(NewsDto::toEntity).toList();
        return newsRepository.saveAll(news);
    }

    @Transactional
    @Override
    public void changeTitle() {
        News news = newsRepository.findById(2576L).orElseThrow(NullPointerException::new);
        news.changeTitle("업데이트 테스트1");
    }


}
