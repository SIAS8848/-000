package com.novel.novel.dao;

import com.novel.novel.entity.AuthorEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AuthorDao extends BaseMapper<AuthorEntity> {
	
}
