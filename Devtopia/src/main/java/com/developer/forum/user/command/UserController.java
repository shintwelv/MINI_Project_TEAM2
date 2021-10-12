package com.developer.forum.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.developer.forum.user.impl.UserService;
import com.developer.forum.user.model.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void insert(UserVO vo) {
		userService.insert(vo);
	}
	
	public void update(UserVO vo) {
		userService.update(vo);
	}
	
	public UserVO select(UserVO vo) {
		return userService.select(vo);
	}
	
	public void delete(UserVO vo) {
		userService.delete(vo);
	}
	
}
