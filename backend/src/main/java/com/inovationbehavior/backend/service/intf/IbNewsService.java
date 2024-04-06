package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.news.IbNews;
import com.inovationbehavior.backend.model.news.News;

import java.util.List;

public interface IbNewsService {
    News getNewsById(Integer id);

    List<IbNews> getNewsList();
}
