package com.novel.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.entity.BookEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2022-02-18 22:47:08
 */
public interface BookService extends IService<BookEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils search(Map<String, Object> params);

    List<BookEntity> queryByTypeId(Long typeId);

    List<BookEntity> queryByAuthorId(Long authorId);
}

