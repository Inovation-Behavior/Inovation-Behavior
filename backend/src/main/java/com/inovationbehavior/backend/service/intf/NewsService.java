package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.news.News;

import java.util.List;

public interface NewsService {
    News getNewsById(Integer id);

    List<News> getNewsList();
}
