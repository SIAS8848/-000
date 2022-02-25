package com.novel.novel.dao;

import com.novel.novel.entity.BookEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao extends BaseMapper<BookEntity> {

    List<BookEntity> queryByTypeId(Long typeId);

    List<BookEntity> queryByAuthorId(Long authorId);
}
