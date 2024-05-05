package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.Patent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
public interface PatentMapper {
    @Select("""
    SELECT appln_ID no, title_zn name,abstract_zn summary, link,update_time,type,status FROM patent
    WHERE appln_ID = #{No}
    """)
    Patent getPatentByNo(String No);

    @Select("""
        SELECT publn_nr FROM patent_publn
        WHERE appln_id = #{No}
    """)
    List<String> getPatentPdfs(String No);

    @Select("""
    SELECT DISTINCT appln_application application FROM patent 
    WHERE appln_application LIKE CONCAT('%',#{key},'%')
    """)
    List<String> getCompanyByKey(String Key);

    @Select("""
    SELECT DISTINCT appln_ID no,title_zn name, appln_application,type,status FROM patent
    WHERE exist = 1
    AND appln_application LIKE CONCAT('%', #{key}, '%')
""")
    List<Patent> getPatentsByKey(String key);

    @Update(
            """
    UPDATE patent
    SET patent.status = 1
    where patent.appln_ID = #{patentNo}
"""
    )
    void updateStatus(String patentNo);
}
