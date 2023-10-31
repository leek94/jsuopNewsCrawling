package com.example.jsoupnewscrawling.controller;

import entity.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.jsoupnewscrawling.service.NewsService;

import java.util.List;


@Controller
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public String news(Model model) throws Exception{
        List<News> newsList = newsService.getNewsData();
        model.addAttribute("news", newsList);

        return "news";
    }

    @GetMapping("/hello")
    public String hi(Model model){
        model.addAttribute("name", "히히");
        return "hello";
    }
}