package com.origin.server.mp.tsf.feign;

import com.origin.server.mp.tsf.model.RequestModel;
import com.origin.server.mp.tsf.model.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.tsf.faulttolerance.annotation.TsfFaultTolerance;
import org.springframework.cloud.tsf.faulttolerance.model.TsfFaultToleranceStragety;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "bg-tsf",fallback = BgTsfFeignFallBack.class)
public interface BgTsf {


    @RequestMapping("/service")
    public String service(@RequestParam String service);

    @RequestMapping("/body")
    ResponseModel test(@RequestBody RequestModel requestModel);

    @RequestMapping("/param")
    ResponseModel test(@RequestParam String v0, @RequestParam String v1, @RequestParam String v2);

    @RequestMapping("/fallback")
    @TsfFaultTolerance(strategy = TsfFaultToleranceStragety.FAIL_FAST)
    String fall();


}
