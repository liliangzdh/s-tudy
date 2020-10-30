package com.yue.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yue.api.entity.UserInfo;
import com.yue.api.mapper.UserInfoMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testSelect() {

//        UserInfo userInfo = new UserInfo();
//        userInfo.setAge(10);
//        userInfo.setId((long) 6);
//        userInfo.setName("李四");
//        userInfoMapper.insert(userInfo);


//        List<UserInfo> userList = userInfoMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);


//        UserInfo userInfo = userInfoMapper.selectById(3);
//        System.out.print("------------->");
//        System.out.print(userInfo);


//        Integer integer = userInfoMapper.selectCount(null);
//        System.out.print("------------->");
//        System.out.println(integer);


//        HashMap<String,Object>map = new HashMap<>();
//        map.put("name","李四");
//        map.put("id",2);
//        System.out.print("------------->");
//        List<UserInfo> userInfos = userInfoMapper.selectByMap(map);
//        userInfos.forEach(System.out::println);


//        List<UserInfo> userInfos = userInfoMapper.selectBatchIds(Arrays.asList(1, 2, 3));
//        userInfos.forEach(System.out::println);




        List<UserInfo> employees = userInfoMapper.selectList(
                new QueryWrapper<UserInfo>()
                        .eq("gender",0)
                        .like("last_name","老师")
                        //.or()//和or new 区别不大
                        .like("email","a")
        );
    }
}
