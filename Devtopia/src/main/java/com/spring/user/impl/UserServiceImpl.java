package com.spring.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.dao.UserDao;
import com.spring.user.model.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Override
	public void insert(UserVO vo) {
		dao.insert(vo);
	}

	@Override
	public void update(UserVO vo) {
		dao.update(vo);
	}
	
	@Override
	public void delete() {
		dao.delete();
	
	}

	@Override
	public UserVO select() {
		return null;
	}
	
}
