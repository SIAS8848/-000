package com.novel.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.entity.TypeEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2022-02-19 10:56:31
 */
public interface TypeService extends IService<TypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

