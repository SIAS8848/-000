package com.novel.novel.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.common.utils.Query;

import com.novel.novel.dao.UserDao;
import com.novel.novel.entity.UserEntity;
import com.novel.novel.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public UserEntity queryByNickname(String nickname) {
        UserEntity userEntity = baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("", nickname));
        return userEntity;
    }

}