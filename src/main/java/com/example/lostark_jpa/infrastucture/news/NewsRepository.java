package com.example.lostark_jpa.infrastucture.news;

import com.example.lostark_jpa.infrastucture.news.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findNewsById(Long id);
}
