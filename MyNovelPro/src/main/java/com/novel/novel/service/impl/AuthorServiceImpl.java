package com.novel.novel.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.common.utils.Query;

import com.novel.novel.dao.AuthorDao;
import com.novel.novel.entity.AuthorEntity;
import com.novel.novel.service.AuthorService;


@Service("authorService")
public class AuthorServiceImpl extends ServiceImpl<AuthorDao, AuthorEntity> implements AuthorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AuthorEntity> page = this.page(
                new Query<AuthorEntity>().getPage(params),
                new QueryWrapper<AuthorEntity>()
        );

        return new PageUtils(page);
    }

}