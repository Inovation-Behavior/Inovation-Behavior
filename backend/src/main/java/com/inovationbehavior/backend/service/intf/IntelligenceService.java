package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.intelligence.Course;
import com.inovationbehavior.backend.model.intelligence.CourseList;
import com.inovationbehavior.backend.model.intelligence.PatentPledge;
import com.inovationbehavior.backend.model.intelligence.PatentPledgeList;
import org.springframework.stereotype.Service;

@Service
public interface IntelligenceService {
    CourseList getCourseByPage(Integer page, Integer size);

    Course getCourseById(Long id);
    PatentPledgeList getPatentPledgeByPage(Integer page, Integer size);

    PatentPledge getPatentPledgeById(Long id);
}
