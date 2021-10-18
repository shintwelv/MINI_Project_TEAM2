package com.developer.forum.user.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.developer.forum.user.impl.UserService;
import com.developer.forum.user.model.UserVO;
import com.oreilly.servlet.MultipartRequest;


@Controller
public class UserCommandHandler {

	private static final String PROFILEIMAGE = "C:\\Temp\\user\\";
	
	@Autowired
	private UserService userService; 

	@RequestMapping(value = {"user/goMain.do"})
	public String goMain() {
		return "user/index";
	}

	@RequestMapping(value = "/user/write.do")
	public String fwdUserIns() {
		return "user/signup";
	}
	@RequestMapping
	public String insertImg(UserVO vo, HttpServletRequest request) throws Exception {
		MultipartRequest multipartRequest;
		try {
			multipartRequest = new MultipartRequest(request, PROFILEIMAGE, 1024*1024*100, "utf-8");
			String fileName = multipartRequest.getOriginalFileName("profileImgLoc");
			vo.setProfileImgLoc(PROFILEIMAGE+fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(vo);
		userService.insert(vo);
		return "user/index";
	}

	@RequestMapping(value = "user/writeAction.do", method = RequestMethod.POST)
	public String insertUser(UserVO vo) throws IOException{
		userService.insert(vo);
		return "user/signupSuccess";
	}

	@RequestMapping(value = "user/updateAction.do", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute UserVO vo) {
		userService.update(vo);
		return "user/updateSuccess";
	}
	@RequestMapping(value = "user/deleteAction.do", method = RequestMethod.POST)
	public String deleteUser() {
		userService.delete();
		return "user/deleteSuccess";
	}

	@RequestMapping(value = "user/update.do")
	public String fwdUserUpt(Model model) {
		UserVO user = userService.select();
		if (user == null) {
			return "user/updateForm";
		}
		model.addAttribute("User", user);
		return "user/updateForm";
	}

	@RequestMapping(value = "user/delete.do")
	public String fwdArticleDel(Model model) {
		UserVO user = userService.select();
		if (user == null) {
			return "user/noUser";
		}
		model.addAttribute("User", user);
		return "user/deleteForm";
	}
	@RequestMapping(value = "user/login.do")
	public String fwdLoginPage(HttpSession session) {
		return "user/login";
	}
	
	
	@RequestMapping(value = "user/logout.do")
	public String logout(HttpSession session) {
        session.invalidate();
        return "direction";
    }

	@RequestMapping(value = "user/loginCheck.do")
	@ResponseBody
	public String loginCheck(UserVO vo, HttpSession session) {
		
		boolean loginSuccess = userService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("user/login");
		
		if (loginSuccess) {
			return "/direction";
		} else {
			return "user/loginFail";
		}
		
	}
}
