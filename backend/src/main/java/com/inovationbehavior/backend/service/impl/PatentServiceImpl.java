package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.PatentMapper;
import com.inovationbehavior.backend.model.Patent;
import com.inovationbehavior.backend.service.intf.PatentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PatentServiceImpl implements PatentService {
    @Autowired
    private PatentMapper patentMapper;

    @Override
    public Patent getPatentByNo(String No){
        return patentMapper.getPatentByNo(No);
    }
}
