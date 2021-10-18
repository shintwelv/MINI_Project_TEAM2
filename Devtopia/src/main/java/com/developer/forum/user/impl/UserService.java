package com.developer.forum.user.impl;

import javax.servlet.http.HttpSession;

import com.developer.forum.user.model.UserVO;

public interface UserService {

	void insert(UserVO vo);
	
	void delete();
		
	void update(UserVO vo);

	UserVO select(UserVO vo);
	
	public boolean loginCheck(UserVO vo, HttpSession session);
	
	public void logout(HttpSession session);
		
	}
	

