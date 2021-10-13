package com.developer.forum.board_job.model;

import java.util.Date;

import lombok.Data;

@Data
public class BoardJobVO {
	private int postNo;
	private String writer;
	private String title;
	private String content;
	private Date writeDate;
	private int viewCount;
}
