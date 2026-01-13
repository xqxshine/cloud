package com.linkedbear.spring6.cloud.provider.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(String name) {
        return "Hello, " + name + "! This is from Service Provider.";
    }
}