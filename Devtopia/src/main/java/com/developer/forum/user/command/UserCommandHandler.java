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
		return "sign-up_final";
	}
	
//	@RequestMapping
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

	@RequestMapping(value = "/user/writeAction.do", method = RequestMethod.POST)
	public String insertUser(UserVO vo, HttpServletRequest request) throws IOException{
		MultipartRequest multipartRequest;
		try {
			multipartRequest = new MultipartRequest(request, PROFILEIMAGE, 1024*1024*100, "utf-8");
			String userId = multipartRequest.getParameter("userId");
			String userPw = multipartRequest.getParameter("userPw");
			String userName = multipartRequest.getParameter("userName");
			String email = multipartRequest.getParameter("email");
			String nickName = multipartRequest.getParameter("nickName");
			String phoneNumber = multipartRequest.getParameter("phoneNumber");
			String address = multipartRequest.getParameter("address");
			String fileName = multipartRequest.getOriginalFileName("profileImgLoc");
			
			vo.setUserId(userId);
			vo.setUserPw(userPw);
			vo.setUserName(userName);
			vo.setEmail(email);
			vo.setNickName(nickName);
			vo.setPhoneNumber(phoneNumber);
			vo.setAddress(address);
			vo.setProfileImgLoc(PROFILEIMAGE+fileName);

			System.out.println(vo);
			userService.insert(vo);
			return "user/signupSuccess";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "user/signupFail";
	}

	@RequestMapping(value = "user/update.do")
	public String fwdUserUpt(Model model, HttpSession session, HttpServletRequest request) {
		boolean isLogin = false;
		String userId = (String) session.getAttribute("userId");
		UserVO vo = new UserVO();
		vo.setUserId(userId);
		System.out.println(userId);
		if (userId != null) {
			isLogin = true;
		}
		if (isLogin) {
			UserVO user = userService.select(vo);
			request.setAttribute("User", user);
			return "user/updateForm";
		} else {
			return "user/loginFail";
		}
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


	@RequestMapping(value = "user/delete.do")
	public String fwdArticleDel(Model model, UserVO vo) {
		UserVO user = userService.select(vo);
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
	public String loginCheck(UserVO vo, HttpSession session) {
		
		boolean loginSuccess = userService.loginCheck(vo, session);
//		ModelAndView mav = new ModelAndView();
//		
//		mav.setViewName("user/login");
		
		if (loginSuccess) {
			return "/direction";
		} else {
			return "user/loginFail";
		}
	}
	
	@RequestMapping(value = "user/addressPopup.do")
	public String fwdAddressPopup() {
		return "address-popup_final";
	}
}
