package com.novel.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.entity.BookshelfEntity;
import com.novel.novel.vo.BookshelfVO;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2022-02-18 22:47:08
 */
public interface BookshelfService extends IService<BookshelfEntity> {

    PageUtils queryPage(Map<String, Object> params, Long userId);

    List<BookshelfVO> queryListByUserId(Long userId);

}

