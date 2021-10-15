package com.spring.user.impl;

import com.spring.user.model.UserVO;

public interface UserService {

	void insert(UserVO vo);
	
	void delete();
		
	void update(UserVO vo);

	UserVO select();
		
	}
	

