package com.yue.api.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yue.api.entity.UserInfo;
import com.yue.api.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserInfo> {


    public List<UserInfo> selectAllList() {
        UserInfoMapper baseMapper = getBaseMapper();
        return baseMapper.selectList(null);
    }

    // 查询所有
    public List<UserInfo> selectAllList(int page) {
        UserInfoMapper baseMapper = getBaseMapper();
        Page<UserInfo> userPage = new Page<>(page,2,false);
        IPage<UserInfo> iPage = baseMapper.selectPage(userPage, null);
        return iPage.getRecords();
    }
}
