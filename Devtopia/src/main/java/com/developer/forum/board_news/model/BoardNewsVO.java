package com.developer.forum.board_news.model;

import java.util.Date;

import lombok.Data;

@Data
public class BoardNewsVO {
	private int postNo;
	private String writer;
	private String title;
	private String content;
	private Date writeDate;
	private int viewCount;
}
