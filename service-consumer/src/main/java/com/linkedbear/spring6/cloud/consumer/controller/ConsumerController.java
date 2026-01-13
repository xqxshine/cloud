package com.linkedbear.spring6.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/hello")
    public String hello(@RequestParam("name") String name) {
        // 使用RestTemplate调用服务提供者
        String url = "http://service-provider/hello?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }
}