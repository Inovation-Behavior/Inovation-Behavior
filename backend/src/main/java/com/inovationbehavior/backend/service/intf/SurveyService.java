package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.survey.Survey;

public interface SurveyService {
    void postSurvey(Survey survey);

    void postIdentification(String patentNo, String identification);

    void postEvaluate(String patentNo, String evaluate);

    void postValue(String patentNo, String value);
}
