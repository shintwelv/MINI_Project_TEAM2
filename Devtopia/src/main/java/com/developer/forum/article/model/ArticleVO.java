package com.developer.forum.article.model;

import java.util.Date;

import lombok.Data;

@Data
public class ArticleVO {
	private int postNo;
	private String writer;
	private String title;
	private String content;
	private Date writeDate;
	private int viewCount;
}
