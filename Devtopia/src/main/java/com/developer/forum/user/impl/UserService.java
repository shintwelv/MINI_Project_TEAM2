package com.developer.forum.user.impl;

import com.developer.forum.user.model.UserVO;

public interface UserService {

	void insert(UserVO vo);

	void delete(UserVO vo);

	void update(UserVO vo);

	UserVO select(UserVO vo);

}