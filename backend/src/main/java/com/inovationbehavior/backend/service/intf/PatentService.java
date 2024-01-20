package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.mapper.PatentMapper;
import com.inovationbehavior.backend.model.Patent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface PatentService {
    Patent getPatentByNo(String No);
}
