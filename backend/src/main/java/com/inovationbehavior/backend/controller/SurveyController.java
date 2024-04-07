package com.inovationbehavior.backend.controller;

import com.inovationbehavior.backend.model.Result;
import com.inovationbehavior.backend.model.survey.AwardInfo;
import com.inovationbehavior.backend.model.survey.Survey;
import com.inovationbehavior.backend.service.intf.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/survey")
@RequiredArgsConstructor
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping("")
    public Result postSurvey(@RequestBody Survey survey){
        surveyService.postSurvey(survey);
        return Result.success();
    }

    @PostMapping("/identification")
    public Result postIdentification(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String identification = requestData.get("identification");
        surveyService.postIdentification(patentNo,identification);
        return Result.success();
    }

    @PostMapping("/enterprise")
    public Result postEnterprise(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String enterprise = requestData.get("enterprise");
        surveyService.postEnterprise(patentNo,enterprise);
        return Result.success();
    }

    @PostMapping("/value")
    public Result postValue(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String value = requestData.get("value");
        surveyService.postValue(patentNo,value);
        return Result.success();
    }

    @PostMapping("/usage")
    public Result postUsage(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String usage = requestData.get("usage");
        surveyService.postUsage(patentNo,usage);
        return Result.success();
    }

    @PostMapping("/policy")
    public Result postPolicy(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String policy = requestData.get("policy");
        surveyService.postPolicy(patentNo,policy);
        return Result.success();
    }

    @PostMapping("/award")
    public Result postAwardInfo(@RequestBody AwardInfo requestData){
        int res = surveyService.postAwardInfo(requestData);
        if(res==1){
            return Result.success();
        }else{
            return Result.error("请勿重复领奖");
        }

    }
}
