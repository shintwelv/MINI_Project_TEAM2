package com.developer.forum.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.developer.forum.user.impl.UserService;
import com.developer.forum.user.model.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/createUser.do")
	public String fwdInsertPage() {
		return "createUser";
	}
	
	@RequestMapping(value = "/createUserAction.do")
	public String insert(UserVO vo) {
		userService.insert(vo);
		return "createSuccess";
	}
	
	@RequestMapping(value = "/modifyUser.do")
	public String fwdUpdatePage() {
		return "modifyUser";
	}
	
	@RequestMapping(value = "/modifyUserAction.do")
	public String update(UserVO vo) {
		userService.update(vo);
		return "modifySuccess";
	}
	
	@RequestMapping(value = "/deleteUser.do")
	public String fwdDeletePage() {
		return "deleteUser";
	}
	
	@RequestMapping(value = "/userInfo.do")
	public String select(UserVO vo, Model model) {
		UserVO user = userService.select(vo);
		model.addAttribute("user", user);
		return "userInfo";
	}
	
	@RequestMapping(value = "/deleteUserAction.do")
	public String delete(UserVO vo) {
		userService.delete(vo);
		return "deleteSucces";
	}
	
}
