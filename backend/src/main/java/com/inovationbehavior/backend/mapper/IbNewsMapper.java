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

    @Select("SELECT id, url_zn, cover, time FROM news WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "urlZn", column = "url_zn"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "time", column = "time")
    })
    News getNewsById(Integer id);

    @Select("SELECT id, url_zn, cover , time FROM news")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "urlZn", column = "url_zn"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "time", column = "time")
    })
    List<IbNews> getNewsList();
}
