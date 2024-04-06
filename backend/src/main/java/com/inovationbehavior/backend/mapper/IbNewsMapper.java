package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.news.IbNews;
import com.inovationbehavior.backend.model.news.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IbNewsMapper {

    @Select("SELECT id,title_zn,title_en, url_zn,url_en, cover, time FROM ib_news WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "titleZn", column = "title_zn"),
            @Result(property = "titleEn", column = "title_en"),
            @Result(property = "urlZn", column = "url_zn"),
            @Result(property = "urlEn", column = "url_en"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "time", column = "time")
    })
    IbNews getNewsById(Integer id);

    @Select("SELECT id,title_zn,title_en, url_zn,url_en, cover , time FROM ib_news")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "titleZn", column = "title_zn"),
            @Result(property = "titleEn", column = "title_en"),
            @Result(property = "urlZn", column = "url_zn"),
            @Result(property = "urlEn", column = "url_en"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "time", column = "time")
    })
    List<IbNews> getNewsList();
}
