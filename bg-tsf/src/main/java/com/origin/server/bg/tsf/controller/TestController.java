package com.origin.server.bg.tsf.controller;

import com.origin.server.bg.tsf.model.RequestModel;
import com.origin.server.bg.tsf.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    Environment environment;

    @RequestMapping("/service")
    public String service(String service) {
        service = service + "-->" + environment.getProperty("spring.application.name") + ":" + environment.getProperty("server.port");
        return service;
    }

    @RequestMapping("/body")
    public ResponseModel test(@RequestBody RequestModel requestModel) {
        return new ResponseModel(requestModel.getV0(), requestModel.getV1(), requestModel.getV2());
    }

    @RequestMapping("/param")
    public ResponseModel test(@RequestParam String v0, @RequestParam String v1, @RequestParam String v2) throws InterruptedException {
        Thread.sleep(Integer.parseInt(v0));
        return new ResponseModel(v0, "BG-TSF" + v1, "BG-TSF" + v2);
    }

}
