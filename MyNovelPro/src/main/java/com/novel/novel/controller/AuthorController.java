package com.novel.novel.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.novel.novel.entity.AuthorEntity;
import com.novel.novel.service.AuthorService;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.common.utils.R;



/**
 * 作者控制器
 *
 *
 */
@RestController
@RequestMapping("novel/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = authorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		AuthorEntity author = authorService.getById(id);

        return R.ok().put("author", author);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody AuthorEntity author){
		authorService.save(author);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody AuthorEntity author){
		authorService.updateById(author);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		authorService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
