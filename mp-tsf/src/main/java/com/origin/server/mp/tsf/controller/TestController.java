package com.origin.server.mp.tsf.controller;

import com.origin.server.mp.tsf.feign.BgTsf;
import com.origin.server.mp.tsf.mapper.TEnvPropertyMapper;
import com.origin.server.mp.tsf.model.RequestModel;
import com.origin.server.mp.tsf.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    BgTsf bgTsf;

    @Autowired
    Environment environment;

    @RequestMapping("/service")
    public String service(String service) {
        service = (service == null ? "Client" : service) + "-->" + environment.getProperty("spring.application.name") + ":" + environment.getProperty("server.port");
        return bgTsf.service(service);
    }

    @RequestMapping("/body")
    public ResponseModel test(@RequestBody RequestModel requestModel) {
        return bgTsf.test(requestModel);
    }

    @RequestMapping("/param")
    public ResponseModel test(@RequestParam String v0, @RequestParam String v1, @RequestParam String v2) {
        return bgTsf.test(v0, v1, v2);
    }


    @RequestMapping("/fall")
    public String test() {
        return bgTsf.fall();
    }

    @Autowired
    TEnvPropertyMapper tEnvPropertyMapper;

    @RequestMapping("/database")
    public Object database() {
        return tEnvPropertyMapper.selectAll();
    }

    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping("/redis")
    public Object redis(String key, String value, String get) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(key, value, 200, TimeUnit.SECONDS);
        return operations.get(get);
    }


}
