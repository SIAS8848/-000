package com.novel.novel.dao;

import com.novel.novel.entity.BookshelfEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novel.novel.vo.BookshelfVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BookshelfDao extends BaseMapper<BookshelfEntity> {

    List<BookshelfVO> queryByUserId(Long userId);
	
}
