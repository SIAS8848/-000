package com.novel.novel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author 
 * @email 
 * @date 2022-02-18 22:47:08
 */
@Data
@TableName("novel_book")
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 作者id
	 */
	private Long authorId;
	/**
	 * 作者昵称
	 */
	private String authorNickname;
	/**
	 * 封面图片地址
	 */
	private String coverImage;
	/**
	 * 小说名字
	 */
	private String novelTitle;
	/**
	 * 简介
	 */
	private String description;
	/**
	 * 上架时间
	 */
	private Date shelfTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 分类id
	 */
	private Long typeId;
	/**
	 * 分类名称
	 */
	private String typeName;

}
