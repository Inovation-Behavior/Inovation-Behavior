package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.survey.Survey;

public interface SurveyService {
    void postSurvey(Survey survey);

    void postIdentification(String patentNo, String identification);

    void postEnterprise(String patentNo, String enterprise);

    void postValue(String patentNo, String value);

    void postUsage(String patentNo, String usage);

    void postPolicy(String patentNo, String policy);
}
