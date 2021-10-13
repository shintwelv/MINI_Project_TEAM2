package com.developer.forum.board_qna.model;

import java.util.Date;

import lombok.Data;

@Data
public class BoardQnAVO {
	private int postNo;
	private String writer;
	private String title;
	private String content;
	private Date writeDate;
	private int viewCount;
}
