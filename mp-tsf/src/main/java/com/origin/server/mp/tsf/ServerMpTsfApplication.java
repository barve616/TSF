package com.origin.server.mp.tsf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.tsf.annotation.EnableTsf;

@SpringBootApplication//(exclude = {TraceWebServletAutoConfiguration})
@EnableFeignClients // 使用Feign微服务调用时请启用
@EnableTsf
@EnableHystrix
@MapperScan("com.origin.server")
public class ServerMpTsfApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerMpTsfApplication.class, args);
    }

}
