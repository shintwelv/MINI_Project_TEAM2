package com.spring.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.dao.UserDao;
import com.spring.user.model.UserVO;

@Service("articleService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public void insert(UserVO vo) {
		dao.insert(vo);
	}
	
}
