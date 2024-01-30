package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.QuestionnaireMapper;
import com.inovationbehavior.backend.model.survey.BusinessActivity;
import com.inovationbehavior.backend.model.survey.PatentStrategy;
import com.inovationbehavior.backend.model.survey.Respondents;
import com.inovationbehavior.backend.service.intf.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    QuestionnaireMapper questionnaireMapper;

    @Override
    public void postRespondents(Respondents resp) {
        questionnaireMapper.postRespondents(resp);
    }

    @Override
    public void postBusinessActivity(BusinessActivity businessActivity) {
        questionnaireMapper.postBusinessActivity(businessActivity);
    }

    @Override
    public void postPatentStrategy(PatentStrategy patentStrategy) {
        questionnaireMapper.postPatentStrategy(patentStrategy);
    }
}
