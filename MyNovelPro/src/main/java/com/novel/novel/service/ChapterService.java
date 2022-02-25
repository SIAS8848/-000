package com.novel.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.novel.novel.common.utils.PageUtils;
import com.novel.novel.entity.ChapterEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2022-02-18 22:47:08
 */
public interface ChapterService extends IService<ChapterEntity> {

    PageUtils queryPage(Map<String, Object> params, Long bookId);

    String uploadFile(MultipartFile file, Long bookId);

}

