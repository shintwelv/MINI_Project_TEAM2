package com.developer.forum.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.user.dao.UserDAO;
import com.developer.forum.user.model.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public void insert(UserVO vo) {
		dao.insert(vo);
	}
	
	@Override
	public void delete(UserVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public void update(UserVO vo) {
		dao.update(vo);
	}
	
	@Override
	public UserVO select(UserVO vo) {
		UserVO user = dao.select(vo);
		return user;
	}
}
