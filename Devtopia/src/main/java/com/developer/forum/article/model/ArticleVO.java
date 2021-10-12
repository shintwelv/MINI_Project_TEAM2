package com.developer.forum.article.model;

import lombok.Data;

@Data
public class ArticleVO {
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private String nickName;
	private String phoneNumber;
	private String address;
}
