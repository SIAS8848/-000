package com.novel.novel.controller;

import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.common.utils.R;
import com.novel.novel.entity.BookEntity;
import com.novel.novel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 书籍控制器
 *
 *
 */
@RestController
@RequestMapping("novel/book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 列表
     * 分页
     * key: page, value: 第几页，默认值是 1
     * key：limit， value：每页有几个，默认值是 10
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bookService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据搜索关键字查找书籍
     * key: page, value: 第几页，默认值是 1
     * key：limit， value：每页有几个，默认值是 10
     * key: keyword，value：查询关键字
     * @return
     */
    @GetMapping("/search")
    public R search(@RequestParam Map<String, Object> params) {
        PageUtils page = bookService.search(params);
        return R.ok().put("page", page);
    }

    /**
     * 根据分类查找所有的书籍
     */
    @GetMapping("/list/type")
    public R getByType(@RequestParam("typeId") Long typeId) {
        List<BookEntity> bookEntities = bookService.queryByTypeId(typeId);
        return R.ok().put("books", bookEntities);
    }

    /**
     * 根据作者查找所有的书籍
     */
    @GetMapping("/list/author")
    public R getByAuthor(@RequestParam("authorId") Long authorId) {
        List<BookEntity> bookEntities = bookService.queryByAuthorId(authorId);
        return R.ok().put("books", bookEntities);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		BookEntity book = bookService.getById(id);

        return R.ok().put("book", book);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody BookEntity book){
        // 设置上架时间为当前时间
        book.setShelfTime(new Date());
        // 设置更新时间为当前时间
        book.setUpdateTime(new Date());
		bookService.save(book);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody BookEntity book){
        // 设置更新时间为当前时间
        book.setUpdateTime(new Date());
		bookService.updateById(book);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		bookService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
