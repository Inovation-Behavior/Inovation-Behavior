package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.NewsMapper;
import com.inovationbehavior.backend.model.news.News;
import com.inovationbehavior.backend.service.intf.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public News getNewsById(Integer id) {
        return newsMapper.getNewsById(id);
    }

    @Override
    public List<News> getNewsList() {
        return newsMapper.getNewsList();
    }
}
