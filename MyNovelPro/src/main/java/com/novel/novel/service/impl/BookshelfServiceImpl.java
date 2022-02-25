package com.novel.novel.service.impl;

import com.novel.novel.vo.BookshelfVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.common.utils.Query;

import com.novel.novel.dao.BookshelfDao;
import com.novel.novel.entity.BookshelfEntity;
import com.novel.novel.service.BookshelfService;


@Service("bookshelfService")
public class BookshelfServiceImpl extends ServiceImpl<BookshelfDao, BookshelfEntity> implements BookshelfService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long userId) {
        IPage<BookshelfEntity> page = this.page(
                // 分页
                new Query<BookshelfEntity>().getPage(params),
                // 查询条件
                new QueryWrapper<BookshelfEntity>().eq("user_id", userId)
        );

        return new PageUtils(page);
    }

    @Override
    public List<BookshelfVO> queryListByUserId(Long userId) {
        return baseMapper.queryByUserId(userId);
    }

}