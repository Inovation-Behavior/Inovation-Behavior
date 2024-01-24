package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.intelligence.Course;
import com.inovationbehavior.backend.model.intelligence.CourseList;
import org.springframework.stereotype.Service;

@Service
public interface IntelligenceService {
    CourseList getCourseByPage(Integer page, Integer size);

    Course getCourseById(Long id);
}
