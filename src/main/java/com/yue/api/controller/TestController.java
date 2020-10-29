package com.yue.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {



    @RequestMapping("hello")
    public String test(){
        return  "hello world";
    }
}
