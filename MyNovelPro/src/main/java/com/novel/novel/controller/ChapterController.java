package com.novel.novel.controller;

import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.common.utils.R;
import com.novel.novel.entity.ChapterEntity;
import com.novel.novel.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * 书籍章节控制器
 *
 *
 */
@RestController
@RequestMapping("novel/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    /**
     * 根据书籍id查询章节列表
     * 分页
     * key: page, value: 第几页，默认值是 1
     * key：limit， value：每页有几个，默认值是 10
     */
    @GetMapping("/list/{bookId}")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("bookId") Long bookId){
        PageUtils page = chapterService.queryPage(params, bookId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ChapterEntity chapter = chapterService.getById(id);

        return R.ok().put("chapter", chapter);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestParam("bookId") Long bookId,
                  @RequestParam("title") String title,
                  @RequestParam("file")MultipartFile file){
        // 上传文件
        String uploadFileDir = chapterService.uploadFile(file, bookId);
        // 根据上传文件后的文件路径构造章节对象
        ChapterEntity chapter = new ChapterEntity();
        chapter.setBookId(bookId);
        chapter.setTitle(title);
        chapter.setFileLocation(uploadFileDir);
        chapter.setUploadTime(new Date());
        chapter.setShowStatus(1);

        // 插入数据库
        chapterService.save(chapter);
        // 返回上传的地址
        return R.ok().put("uploadFileDir", uploadFileDir);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody ChapterEntity chapter){
		chapterService.updateById(chapter);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		chapterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
