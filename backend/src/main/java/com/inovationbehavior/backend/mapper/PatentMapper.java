package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.Patent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PatentMapper {
    @Select("""
    SELECT * FROM patent
    WHERE No = #{No}
    """)
    Patent getPatentByNo(String No);
}
