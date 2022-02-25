package com.novel.novel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novel.novel.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    /**
     * 根据nickname 查询用户
     * @param nickname
     * @return
     */
    UserEntity queryByNickname(String nickname);
	
}
