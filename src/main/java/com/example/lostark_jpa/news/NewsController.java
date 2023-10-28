package com.example.lostark_jpa.news;

import com.example.lostark_jpa.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;


    @GetMapping("/")
    public ResponseEntity hello(){
        return ResponseEntity.ok("hello");
    }


    @GetMapping("/news")
    public ResponseEntity getAllNews(){
        var response = newsService.findAllNews();
        return ResponseEntity.ok(response);
    }



}
