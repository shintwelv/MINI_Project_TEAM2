package com.developer.forum.user.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.user.dao.UserDao;
import com.developer.forum.user.model.UserVO;

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
	public UserVO select(UserVO vo) {
		return dao.select(vo);
	}
		
	public boolean loginCheck(UserVO vo, HttpSession session) {
		boolean result = false;
		
		UserVO user = dao.loginCheck(vo);
		if (user != null) {
			session.setAttribute("userId",vo.getUserId());
			result = true;
		}
		
		return result;
	}

	public void logout(HttpSession session) {
		dao.logout(session);
	}


	public UserVO getUser(UserVO vo) {
		return null;
	}

	public boolean loginCheck() {
		return false;
	}
	
}
