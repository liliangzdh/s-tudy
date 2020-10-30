package com.yue.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yue.api.entity.UserInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
@CacheConfig(cacheNames = "userInfo")
public interface UserInfoService extends IService<UserInfo> {

    @Cacheable(key = "'test_12123'")
    List<UserInfo> selectAllList();

    // 查询所有
    List<UserInfo> selectAllList(int page);

    @CacheEvict(key = "'test_12123'")
    int add(UserInfo info);

}
