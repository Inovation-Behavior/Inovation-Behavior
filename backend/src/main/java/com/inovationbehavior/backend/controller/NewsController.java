package com.inovationbehavior.backend.controller;

import com.inovationbehavior.backend.model.Result;
import com.inovationbehavior.backend.service.intf.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("")
    public Result getNewsList(){
        return Result.success(newsService.getNewsList());
    }

    @GetMapping("singleNews/{id}")
    public Result getNewsById(@PathVariable("id") Integer id){
        return Result.success(newsService.getNewsById(id));
    }
}
