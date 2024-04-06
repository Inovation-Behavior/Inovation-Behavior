package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.IbNewsMapper;
import com.inovationbehavior.backend.model.news.IbNews;
import com.inovationbehavior.backend.model.news.News;
import com.inovationbehavior.backend.service.intf.IbNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IbNewsServiceImpl implements IbNewsService {
    @Autowired
    private IbNewsMapper ibNewsMapper;
    @Override
    public IbNews getNewsById(Integer id) {
        return ibNewsMapper.getNewsById(id);
    }

    @Override
    public List<IbNews> getNewsList() {
        return ibNewsMapper.getNewsList();
    }
}
