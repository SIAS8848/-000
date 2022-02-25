package com.novel.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.novel.novel.common.exception.NovelException;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.common.utils.Query;
import com.novel.novel.dao.ChapterDao;
import com.novel.novel.entity.ChapterEntity;
import com.novel.novel.service.ChapterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;


@Service("chapterService")
public class ChapterServiceImpl extends ServiceImpl<ChapterDao, ChapterEntity> implements ChapterService {

    //文件根目录
    @Value("${upload.file.dir}")
    private final String filePath = "D:/file";
    //文件存放路径
    @Value("${upload.file.url}")
    private final String fileDir = "/upload/file/";

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long bookId) {
        IPage<ChapterEntity> page = this.page(
                new Query<ChapterEntity>().getPage(params),
                new QueryWrapper<ChapterEntity>().eq("book_id", bookId)
        );

        return new PageUtils(page);
    }

    @Override
    public String uploadFile(MultipartFile file, Long bookId) {
        if (file.isEmpty()) {
            throw new NovelException("上传的文件不能为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 防止重名
        fileName = UUID.randomUUID() + suffixName;
        String allPath = filePath.trim() + fileDir.trim() + bookId + "/" + fileName.trim();
        File dest = new File(allPath);
        // 检测是否存在目录，如果不存在则创建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            System.out.print(fileDir.trim() + bookId + "/" + fileName.trim());
//            return fileDir.trim()+ fileName.trim();//"上传成功";
            return ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path(fileDir.trim() + bookId + "/" + fileName.trim())
                    .toUriString();
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            throw new NovelException(e.getMessage());
        }
    }

}