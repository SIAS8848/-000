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
@TableName("novel_author")
public class AuthorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 作者简介
	 */
	private String info;

}
