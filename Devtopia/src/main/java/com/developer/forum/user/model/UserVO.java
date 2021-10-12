package com.developer.forum.user.model;

import lombok.Data;

@Data
public class UserVO {
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private String nickName;
	private String phoneNumber;
	private String address;
}
