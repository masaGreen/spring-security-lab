package com.securitydemotest.demosecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/reg")
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello security";
    }
    @GetMapping("/secured")
    public String secure(){
        return "a secure endpoint";
    }
    @GetMapping("/denied")
    public String denied(){
        return "there was an exception";
    }
}
