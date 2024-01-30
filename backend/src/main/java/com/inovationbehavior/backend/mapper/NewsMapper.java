package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.news.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {

    @Select("SELECT id, title_zn, title_en, title_de, contains_zn, contains_en, contains_de, time FROM news WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "titleZn", column = "title_zn"),
            @Result(property = "titleEn", column = "title_en"),
            @Result(property = "titleDe", column = "title_de"),
            @Result(property = "containsZn", column = "contains_zn"),
            @Result(property = "containsEn", column = "contains_en"),
            @Result(property = "containsDe", column = "contains_de"),
            @Result(property = "time", column = "time")
    })
    News getNewsById(Integer id);

    @Select("SELECT id, title_zn, title_en, title_de, time FROM news")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "titleZn", column = "title_zn"),
            @Result(property = "titleEn", column = "title_en"),
            @Result(property = "titleDe", column = "title_de"),
            @Result(property = "time", column = "time")
    })
    List<News> getNewsList();
}
