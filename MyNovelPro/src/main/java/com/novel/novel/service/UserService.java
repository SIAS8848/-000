package com.novel.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.entity.UserEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2022-02-18 22:47:08
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    UserEntity queryByNickname(String nickname);
}

