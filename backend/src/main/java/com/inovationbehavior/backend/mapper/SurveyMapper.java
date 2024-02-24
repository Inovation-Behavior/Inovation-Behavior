package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.survey.Survey;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SurveyMapper {
    @Insert("insert into survey (patent_no, identification, evaluate, value) values (#{patentNo},#{identification},#{evaluate},#{value})")
    void postSurvey(Survey survey);

    @Insert("INSERT INTO survey (patent_no, identification) \n" +
            "VALUES (#{patentNo}, #{identification}) \n" +
            "ON DUPLICATE KEY UPDATE identification = VALUES(identification);")
    void postIdentification(String patentNo, String identification);

    @Insert("INSERT INTO survey (patent_no, evaluate) \n" +
            "VALUES (#{patentNo}, #{evaluate}) \n" +
            "ON DUPLICATE KEY UPDATE evaluate = VALUES(evaluate);")
    void postEvaluate(String patentNo, String evaluate);

    @Insert("INSERT INTO survey (patent_no, value) \n" +
            "VALUES (#{patentNo}, #{value}) \n" +
            "ON DUPLICATE KEY UPDATE value = VALUES(value);")
    void postValue(String patentNo, String value);
}
