package com.developer.forum.board_free.model;

import java.util.Date;

import lombok.Data;

@Data
public class BoardFreeVO {
	private int postNo;
	private String writer;
	private String title;
	private String content;
	private Date writeDate;
	private int viewCount;
}
