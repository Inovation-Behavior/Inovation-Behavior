package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.survey.AwardInfo;
import com.inovationbehavior.backend.model.survey.Survey;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SurveyMapper {
    @Insert("insert into survey (patent_no, identification, evaluate, value) values (#{patentNo},#{identification},#{evaluate},#{value})")
    void postSurvey(Survey survey);

    @Insert("INSERT INTO survey (patent_no, identification) \n" +
            "VALUES (#{patentNo}, #{identification}) \n" +
            "ON DUPLICATE KEY UPDATE identification = VALUES(identification);")
    void postIdentification(String patentNo, String identification);

    @Insert("INSERT INTO survey (patent_no, enterprise) \n" +
            "VALUES (#{patentNo}, #{enterprise}) \n" +
            "ON DUPLICATE KEY UPDATE enterprise = VALUES(enterprise);")
    void postEnterprise(String patentNo, String enterprise);

    @Insert("INSERT INTO survey (patent_no, value) \n" +
            "VALUES (#{patentNo}, #{value}) \n" +
            "ON DUPLICATE KEY UPDATE value = VALUES(value);")
    void postValue(String patentNo, String value);

    @Insert("INSERT INTO survey (patent_no, `use`) \n" +
            "VALUES (#{patentNo}, #{use}) \n" +
            "ON DUPLICATE KEY UPDATE `use` = VALUES(`use`);")
    void postUsage(String patentNo, String use);


    @Insert("INSERT INTO survey (patent_no, policy) \n" +
            "VALUES (#{patentNo}, #{policy}) \n" +
            "ON DUPLICATE KEY UPDATE policy = VALUES(policy);")
    void postPolicy(String patentNo, String policy);

    @Insert("INSERT INTO survey (patent_no, award, address) " +
            "VALUES (#{patentNo}, #{award}, #{address}) " +
            "ON DUPLICATE KEY UPDATE award = IFNULL(award, VALUES(award)), address = VALUES(address);")
    int postAwardInfo(String patentNo, Integer award, String address);

    @Select("SELECT COUNT(*) FROM survey WHERE patent_no = #{patentNo} AND award IS NOT NULL")
    int checkAward(String patentNo);
}
