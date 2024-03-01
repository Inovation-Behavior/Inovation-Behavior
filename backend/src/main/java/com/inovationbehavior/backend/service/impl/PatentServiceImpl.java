package com.inovationbehavior.backend.service.impl;

import com.google.gson.Gson;
import com.inovationbehavior.backend.mapper.PatentMapper;
import com.inovationbehavior.backend.model.Patent;
import com.inovationbehavior.backend.service.intf.PatentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PatentServiceImpl implements PatentService {
    @Autowired
    private PatentMapper patentMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Patent getPatentByNo(String no){
        // Redis的key
        String redisKey = "patent:" + no;

        // 尝试从Redis中获取记录
        String patentJson = redisTemplate.opsForValue().get(redisKey);
        Patent patent = null;
        Gson gson = new Gson();
        if (patentJson != null && !patentJson.isEmpty()) {
            // 如果Redis中有记录，反序列化后返回
            patent = gson.fromJson(patentJson, Patent.class);
        } else {
            // Redis中没有记录，查询数据库
            patent = patentMapper.getPatentByNo(no);

            if (patent != null) {
                // 数据库中查询到了记录，序列化后存储到Redis中
                redisTemplate.opsForValue().set(redisKey, gson.toJson(patent));
            }else{
                //设置null值
                redisTemplate.opsForValue().set(redisKey,gson.toJson(null));
                redisTemplate.expire(redisKey,24, TimeUnit.HOURS);
            }
        }

        return patent;
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
