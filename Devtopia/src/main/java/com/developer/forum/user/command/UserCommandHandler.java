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

import com.developer.forum.user.impl.UserService;
import com.developer.forum.user.model.UserVO;
import com.oreilly.servlet.MultipartRequest;


@Controller
public class UserCommandHandler {

	private static final String PROFILEIMAGE = "C:\\Devtopia\\Devtopia\\src\\main\\webapp\\resources\\userProfileIMG";
	
	@Autowired
	private UserService userService; 

	@RequestMapping(value = "writeUser.do")
	public String fwdUserIns() {
		return "user/sign-up_final";
	}
	
	@RequestMapping(value = "writeUserAction.do", method = RequestMethod.POST)
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
			vo.setProfileImgLoc("./resources/userProfileIMG/"+fileName);

			userService.insert(vo);
			return "user/signupSuccess";
		} catch (IOException e) {
			return "user/signUpFail";
		}
	}

	@RequestMapping(value = "updateUser.do")
	public String fwdUserUpt(Model model, HttpSession session, HttpServletRequest request) {
		boolean isLogin = false;
		String userId = (String) session.getAttribute("userId");
		UserVO vo = new UserVO();
		vo.setUserId(userId);
		if (userId != null) {
			isLogin = true;
		}
		if (isLogin) {
			UserVO user = userService.select(vo);
			request.setAttribute("User", user);
			return "user/user-info-popup_final";
		} else {
			return "user/updateError";
		}
	}
	
	@RequestMapping(value = "updateUserAction.do", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute UserVO vo, HttpServletRequest request) {
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
			vo.setProfileImgLoc("./resources/userProfileIMG/"+fileName);

			System.out.println(vo);
			userService.update(vo);
			return "user/updateSuccess";
		} catch (IOException e) {
			return "user/updateError";
		}
	}
	
	@RequestMapping(value = "deleteUserAction.do")
	public String deleteUser(UserVO vo, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		System.out.println(vo);
		userService.delete(vo);
		session.invalidate();
		
		return "fwd_index";
	}

	@RequestMapping(value = "deleteUser.do")
	public String fwdArticleDel() {
		return "user/deleteConfirm";
	}
	
	@RequestMapping(value = "logout.do")
	public String logout(HttpSession session) {
        session.invalidate();
        return "fwd_index";
    }

	@RequestMapping(value = "loginCheck.do")
	public String loginCheck(UserVO vo, HttpSession session) {
		
		boolean loginSuccess = userService.loginCheck(vo, session);
		
		if (loginSuccess) {
			return "login-success";
		} else {
			return "user/loginFail";
		}
	}
	
	@RequestMapping(value = "addressPopup.do")
	public String fwdAddressPopup() {
		return "address-popup_final";
	}
}
