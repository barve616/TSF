package com.origin.server.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.tsf.annotation.EnableTsf;


@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients // 使用Feign微服务调用时请启用
@EnableTsf
@EnableHystrix
public class ServerZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerZuulApplication.class, args);
    }

}
