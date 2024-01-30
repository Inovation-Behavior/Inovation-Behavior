package com.inovationbehavior.backend.mapper;

import com.inovationbehavior.backend.model.survey.BusinessActivity;
import com.inovationbehavior.backend.model.survey.PatentStrategy;
import com.inovationbehavior.backend.model.survey.Respondents;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionnaireMapper {

    @Insert("insert into respondents_identification (patent_no, gender, major, degree, role, income, experience) values (#{patentNo},#{gender},#{major},#{degree},#{role},#{income},#{experience})")
    void postRespondents(Respondents resp);


    @Insert("insert into business_activity (patent_no,stage,charac,users,sector,inventor,revenue,continue_develop,importance,market_conditions,patent,major_hurdles) values (#{patentNo},#{stage},#{charac},#{users},#{sector},#{inventor},#{revenue},#{continueDevelop},#{importance},#{marketConditions},#{patent},#{majorHurdles})")
    void postBusinessActivity(BusinessActivity businessActivity);

    @Insert("insert into patent_strategy (patent_no,financial_value,hold_reason,importance,commercialize_methods,is_successful,obstacles_extent,facilitate_options,public_support) values (#{patentNo},#{financialValue},#{holdReason},#{importance},#{commercializeMethods},#{isSuccessful},#{obstaclesExtent},#{facilitateOptions},#{publicSupport});")
    void postPatentStrategy(PatentStrategy patentStrategy);
}
