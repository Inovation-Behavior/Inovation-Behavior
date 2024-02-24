package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.Patent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PatentMapper {
    @Select("""
    SELECT * FROM patent
    WHERE No = #{No}
    """)
    Patent getPatentByNo(String No);

    @Select("""
    SELECT DISTINCT application FROM patent 
    WHERE application LIKE CONCAT('%',#{key},'%')
    """)
    List<String> getCompanyByKey(String Key);

    @Select("""
    SELECT no,name, application FROM patent
    WHERE application LIKE CONCAT('%', #{company}, '%')
    AND no LIKE CONCAT('%', #{no}, '%')
""")
    List<Map<String, String>> getPatentByKey(String company, String no);

}
