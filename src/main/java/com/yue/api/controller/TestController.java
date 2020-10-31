package com.yue.api.controller;


import com.google.gson.Gson;
import com.yue.api.entity.UserInfo;
import com.yue.api.service.RedisService;
import com.yue.api.service.UserInfoService;
import com.yue.api.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("test")
@RestController
public class TestController {


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisService redisService;


    @RequestMapping("/page")
    public String page(int page) {
        System.out.println(" page:   " + page);
        List<UserInfo> userInfos = userInfoService.selectAllList(page);


        return new Gson().toJson(userInfos);
    }


    @RequestMapping("/all")
    public String all() {
        List<UserInfo> userInfos = userInfoService.selectAllList();
        return new Gson().toJson(userInfos);
    }


    @RequestMapping("/test")
    public String test() {
        List<UserInfo> name = (List<UserInfo>) redisService.get("userInfo");


        for (UserInfo userInfo : name) {
            System.out.println(new Gson().toJson(userInfo));
        }


        return name.toString();
    }


    @RequestMapping("/add")
    public void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId((long) 9);
        userInfo.setName("胀气");
        userInfo.setAge(20);
        userInfo.setEmail("212@qq.com");
        userInfoService.add(userInfo);

    }


}
