package com.yue.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yue.api.entity.UserInfo;
import com.yue.api.mapper.UserInfoMapper;
import com.yue.api.service.UserInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
//public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> {
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public List<UserInfo> selectAllList() {
        UserInfoMapper baseMapper = getBaseMapper();
        return baseMapper.selectList(null);
    }

    @Override
    // 查询所有
    public List<UserInfo> selectAllList(int page) {
        UserInfoMapper baseMapper = getBaseMapper();
        Page<UserInfo> userPage = new Page<>(page,2,false);
        IPage<UserInfo> iPage = baseMapper.selectPage(userPage, null);
        return iPage.getRecords();
    }

    @Override
    public int add(UserInfo info) {
        UserInfoMapper baseMapper = getBaseMapper();
        return baseMapper.insert(info);
    }
}
