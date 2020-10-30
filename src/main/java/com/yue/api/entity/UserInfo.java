package com.yue.api.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class UserInfo {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
