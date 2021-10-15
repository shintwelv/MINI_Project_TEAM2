package com.spring.user.command;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.user.impl.UserService;
import com.spring.user.model.UserVO;


@Controller
public class UserCommandHandler {
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = {"/goMain.do", "/"})
	public String goMain() {
		return "index";
	}
	
	@RequestMapping(value = "/write.do")
	public String fwdArticleIns() {
		return "signup";
	}
	
	@RequestMapping(value = "/writeAction.do", method = RequestMethod.POST)
	public String insertUser(UserVO vo) throws IOException{
		userService.insert(vo);
			return "signupSuccess";
	}
	
		@RequestMapping(value = "/deleteAction.do", method = RequestMethod.POST)
	public String deleteUser() {
		userService.delete();
		return "deleteSuccess";
	}
	@RequestMapping(value = "/updateAction.do", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute UserVO vo) {
		userService.update(vo);
		return "updateSuccess";
	}
		@RequestMapping(value = "/update.do")
		public String fwdArticleUpt(Model model) {
			UserVO user = userService.select();
			if (user == null) {
				return "updateForm";
			}
			model.addAttribute("User",user);
			return "updateForm";
	}
	
}

