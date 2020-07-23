package com.origin.server.bg.tsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.tsf.annotation.EnableTsf;

@SpringBootApplication//(exclude = {TraceWebServletAutoConfiguration})
@EnableFeignClients // 使用Feign微服务调用时请启用
@EnableTsf
public class ServerBgTsfApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerBgTsfApplication.class, args);
    }
}
