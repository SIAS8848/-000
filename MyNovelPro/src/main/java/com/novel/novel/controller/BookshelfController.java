package com.novel.novel.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.novel.novel.vo.BookshelfVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.novel.novel.entity.BookshelfEntity;
import com.novel.novel.service.BookshelfService;
import com.novel.novel.common.utils.R;



/**
 * 书架控制器
 *
 *
 */
@RestController
@RequestMapping("novel/bookshelf")
public class BookshelfController {
    @Autowired
    private BookshelfService bookshelfService;

    /**
     * 根据用户id查询书架列表
     *
     * @param userId 用户id
     */
    @GetMapping("/list")
    public R list(@RequestParam("userId") Long userId){
        List<BookshelfVO> bookshelfVOS = bookshelfService.queryListByUserId(userId);

        return R.ok().put("list", bookshelfVOS);
    }


    /**
     * 信息，根据id查询书架信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		BookshelfEntity bookshelf = bookshelfService.getById(id);

        return R.ok().put("bookshelf", bookshelf);
    }

    /**
     * 保存，添加书架
     */
    @PostMapping("/save")
    public R save(@RequestBody BookshelfEntity bookshelf){
        // 设置更新时间为当前时间
        bookshelf.setUpdateTime(new Date());
		bookshelfService.save(bookshelf);

        return R.ok();
    }

    /**
     * 删除，根据id删除书架
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		bookshelfService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 修改
     * 主要是修改更新时间，每次阅读时更新
     */
    @PostMapping("/update")
    public R update(@RequestBody BookshelfEntity bookshelf){
        // 设置更新时间为当前时间
        bookshelf.setUpdateTime(new Date());
        bookshelfService.updateById(bookshelf);

        return R.ok();
    }

}
