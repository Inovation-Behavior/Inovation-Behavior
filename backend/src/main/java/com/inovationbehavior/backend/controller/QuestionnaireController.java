package com.inovationbehavior.backend.controller;

import com.inovationbehavior.backend.model.Result;
import com.inovationbehavior.backend.model.survey.BusinessActivity;
import com.inovationbehavior.backend.model.survey.PatentStrategy;
import com.inovationbehavior.backend.model.survey.Respondents;
import com.inovationbehavior.backend.service.intf.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    QuestionnaireService questionnaireService;

    @PostMapping("/respondents")
    public Result postRespondents(@RequestBody Respondents resp){
        questionnaireService.postRespondents(resp);
        return Result.success();
    }

    @PostMapping("businessActivity")
    public Result postBusinessActivity(@RequestBody BusinessActivity businessActivity){
        questionnaireService.postBusinessActivity(businessActivity);
        return Result.success();
    }

    @PostMapping("patentStrategy")
    public Result postPatentStrategy(@RequestBody PatentStrategy patentStrategy){
        questionnaireService.postPatentStrategy(patentStrategy);
        return Result.success();
    }
}
