package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.PatentMapper;
import com.inovationbehavior.backend.model.Patent;
import com.inovationbehavior.backend.service.intf.PatentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PatentServiceImpl implements PatentService {
    @Autowired
    private PatentMapper patentMapper;

    @Override
    public Patent getPatentByNo(String No){
        return patentMapper.getPatentByNo(No);
    }

    @Override
    public List<Map<String, String>> getPatentByKey(String company, String no) {
        List<Map<String, String>> key = patentMapper.getPatentByKey(company,no);
        System.out.println(key);
        return key;
    }

    @Override
    public List<String> getCompanyByKey(String key) {
        List<String> companies = patentMapper.getCompanyByKey(key);
        System.out.print(companies+key);
        return companies;
    }
}
