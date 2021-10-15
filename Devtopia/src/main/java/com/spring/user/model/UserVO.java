package com.spring.user.model;

import org.springframework.web.multipart.MultipartFile;

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
	//private MultipartFile profileImgLoc;
	
	@Override
	public String toString() {
		return "UserVO [userId=" + this.userId + ", userPw=" + this.userPw + ", userName=" + this.userName + ", email=" + this.email
				+ ", nickName=" + this.nickName + ", phoneNumber=" + this.phoneNumber + ", address=" + this.address + ""
						+ "]";
	}
	//"profileImgLoc" + this.profileImgLoc+
		
}