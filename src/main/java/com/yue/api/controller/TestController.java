package com.yue.api.controller;


import com.google.gson.Gson;
import com.yue.api.entity.UserInfo;
import com.yue.api.service.RedisService;
import com.yue.api.service.UserInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "测试模块", description = "测试模拟", value = "测试模拟")
@RequestMapping("test")
@RestController
public class TestController {


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "获取列表", notes = "获取列表")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page(@ApiParam(name="page",value="第几页",required=true)int page) {
        System.out.println(" page:   " + page);
        List<UserInfo> userInfos = userInfoService.selectAllList(page);


        return new Gson().toJson(userInfos);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all() {
        List<UserInfo> userInfos = userInfoService.selectAllList();
        return new Gson().toJson(userInfos);
    }


    @ApiOperation(value = "修改测试", notes = "车市")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "String"),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "String")
    })
    public String test() {
        List<UserInfo> name = (List<UserInfo>) redisService.get("userInfo");


        for (UserInfo userInfo : name) {
            System.out.println(new Gson().toJson(userInfo));
        }


        return name.toString();
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId((long) 9);
        userInfo.setName("胀气");
        userInfo.setAge(20);
        userInfo.setEmail("212@qq.com");
        userInfoService.add(userInfo);

    }


}
