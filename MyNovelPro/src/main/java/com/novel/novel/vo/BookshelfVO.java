package com.novel.novel.vo;

import com.novel.novel.entity.BookEntity;
import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class BookshelfVO {

    /**
     * 书架自增id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 书籍id
     */
    private Long bookId;
    /**
     * 书籍
     */
    private BookEntity book;

}
