package com.origin.server.mp.tsf.feign;

import com.origin.server.mp.tsf.model.RequestModel;
import com.origin.server.mp.tsf.model.ResponseModel;
import org.springframework.stereotype.Component;

@Component
public class BgTsfFeignFallBack implements BgTsf {


    @Override
    public String service(String service) {
        return service + "-->" + "MP-TSF降级处理";
    }

    @Override
    public ResponseModel test(RequestModel requestModel) {
        return new ResponseModel("测试TSF服务降级", "测试TSF服务降级", "测试TSF服务降级");
    }

    @Override
    public ResponseModel test(String v0, String v1, String v2) {
        return new ResponseModel("测试TSF服务降级", "测试TSF服务降级", "测试TSF服务降级");
    }

    @Override
    public String fall() {
        return "测试TSF服务降级";
    }


}
