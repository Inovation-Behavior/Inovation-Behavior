package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.survey.BusinessActivity;
import com.inovationbehavior.backend.model.survey.PatentStrategy;
import com.inovationbehavior.backend.model.survey.Respondents;

public interface QuestionnaireService {
    void postRespondents(Respondents resp);

    void postBusinessActivity(BusinessActivity businessActivity);

    void postPatentStrategy(PatentStrategy patentStrategy);
}
