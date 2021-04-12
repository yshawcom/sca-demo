package com.yshaw.alibaba.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shaw
 * @date 2021-04-07
 */
@RestController
public class NacosController {

    @Value("${spring.application.name}")
    private String appName;

    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

    public NacosController(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/echo/app-name")
    public String echoAppName() {
        // 使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }


}
