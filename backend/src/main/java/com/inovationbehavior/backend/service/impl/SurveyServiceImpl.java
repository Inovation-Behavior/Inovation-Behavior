package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.SurveyMapper;
import com.inovationbehavior.backend.model.survey.AwardInfo;
import com.inovationbehavior.backend.model.survey.Survey;
import com.inovationbehavior.backend.service.intf.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyMapper surveyMapper;
    @Override
    public void postSurvey(Survey survey) {
        surveyMapper.postSurvey(survey);
    }

    @Override
    public void postIdentification(String patentNo, String identification) {
        surveyMapper.postIdentification(patentNo,identification);
    }

    @Override
    public void postEnterprise(String patentNo, String enterprise) {
        surveyMapper.postEnterprise(patentNo,enterprise);
    }

    @Override
    public void postValue(String patentNo, String value) {
        surveyMapper.postValue(patentNo,value);
    }

    @Override
    public void postUsage(String patentNo, String usage) {
        surveyMapper.postUsage(patentNo, usage);
    }

    @Override
    public void postPolicy(String patentNo, String policy) {
        surveyMapper.postPolicy(patentNo, policy);
    }

    @Override
    public int postAwardInfo(AwardInfo requestData) {
        System.out.println(surveyMapper.checkAward(requestData.getPatentNo()));
        if(surveyMapper.checkAward(requestData.getPatentNo())==0){
            surveyMapper.postAwardInfo(requestData.getPatentNo(), requestData.getAward(),requestData.getAddress());
            return 1;
        }
        return 0;
    }
}
