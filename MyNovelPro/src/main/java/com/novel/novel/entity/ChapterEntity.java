package com.novel.novel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName("novel_chapter")
public class ChapterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 书籍id
	 */
	private Long bookId;
	/**
	 * 章节标题
	 */
	private String title;
	/**
	 * 文件位置
	 */
	private String fileLocation;
	/**
	 * 上传时间
	 */
	private Date uploadTime;
	/**
	 * 显示状态[0-不显示，1-显示]
	 */
	@TableLogic(value = "1", delval = "0")
	private Integer showStatus;

}
