package com.origin.server.zuul.filter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

@Configuration
public class ZuulFilterDemo extends ZuulFilter {


    static Logger logger = LoggerFactory.getLogger(ZuulFilterDemo.class);


    @Autowired
    DiscoveryClient discoveryClient;

    static Gson gson = new GsonBuilder().create();


    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();

        Object service = requestContext.get(FilterConstants.SERVICE_ID_KEY);
        Map<String,String[]> map = requestContext.getRequest().getParameterMap();

        logger.info("URL:{}", requestContext.getRequest().getRequestURI());
        logger.info("Service:{}", service == null ? "NULL" : service.toString());
        logger.info("RequestMap:{}", map == null ? "NULL" : gson.toJson(map));


        if ("bg".equals(requestContext.getRequest().getHeader("service"))) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("禁止访问");
            requestContext.getResponse().setContentType("application/text; charset=utf-8");
            logger.info("非法访问");
        }

        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }
}
