package com.yue.api.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

//    private static final long serialVersionUID = 121232323;
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
