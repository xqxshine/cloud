package com.linkedbear.spring6.cloud.provider.controller;

import com.linkedbear.spring6.cloud.provider.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }
}