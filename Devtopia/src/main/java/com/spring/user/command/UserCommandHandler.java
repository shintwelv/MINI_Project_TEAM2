package com.spring.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		return "writeForm";
	}
	
	@RequestMapping(value = "/writeAction.do", method = RequestMethod.POST)
	public String insertArticle(UserVO vo) {
		userService.insert(vo);
		return "writeSuccess";
	}

}
