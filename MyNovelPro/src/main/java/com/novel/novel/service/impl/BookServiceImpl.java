package com.novel.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.novel.common.utils.Constant;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.common.utils.Query;
import com.novel.novel.dao.BookDao;
import com.novel.novel.entity.BookEntity;
import com.novel.novel.service.BookService;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookDao, BookEntity> implements BookService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BookEntity> page = this.page(
                new Query<BookEntity>().getPage(params),
                new QueryWrapper<BookEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils search(Map<String, Object> params) {
        // 获取查询关键字
        String keyword = (String) params.getOrDefault(Constant.KEYWORD, "");
        IPage<BookEntity> page = this.page(
                new Query<BookEntity>().getPage(params),
                new QueryWrapper<BookEntity>()
                        .like("novel_title", keyword)
                        .or()
                        .like("author_nickname", keyword)
                        .or()
                        .like("description", keyword)
                        .or()
                        .like("type_name", keyword)
        );
        return new PageUtils(page);
    }

    @Override
    public List<BookEntity> queryByTypeId(Long typeId) {
        return baseMapper.queryByTypeId(typeId);
    }

    @Override
    public List<BookEntity> queryByAuthorId(Long authorId) {
        return baseMapper.queryByAuthorId(authorId);
    }

}