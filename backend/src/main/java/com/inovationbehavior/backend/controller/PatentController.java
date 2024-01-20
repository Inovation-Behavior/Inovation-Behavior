package com.inovationbehavior.backend.controller;

import com.inovationbehavior.backend.model.Patent;
import com.inovationbehavior.backend.model.Result;
import com.inovationbehavior.backend.service.intf.PatentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/patents")
public class PatentController {
    @Autowired
    PatentService patentService;

    @GetMapping("/{No}")
    public Result getPatentByNo(@PathVariable String No) {
        Patent tmp = patentService.getPatentByNo(No);
        if (tmp != null) {
            return Result.success(tmp);
        }
        return Result.error("未找到No：" + No);
    }

}
