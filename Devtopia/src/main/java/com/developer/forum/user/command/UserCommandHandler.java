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

	@RequestMapping(value = {"goUserMain.do"})
	public String goMain() {
		return "user/index";
	}

	@RequestMapping(value = "writeUser.do")
	public String fwdUserIns() {
		return "sign-up_final";
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
			return "signupSuccess";
		} catch (IOException e) {
			return "signupFail";
		}
	}

	@RequestMapping(value = "/updateUser.do")
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
			return "user-info-popup_final";
		} else {
			return "user/loginFail";
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
			vo.setProfileImgLoc(PROFILEIMAGE+fileName);

			System.out.println(vo);
			userService.update(vo);
			//수정 완료됐다는 페이지가 떠야함
			return "updateSuccess";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "user/signupFail";
	}
	@RequestMapping(value = "deleteUserAction.do")
	public String deleteUser(UserVO vo, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		userService.delete(vo);
		
		return "deleteSuccess";
	}


	@RequestMapping(value = "deleteUser.do")
	public String fwdArticleDel() {
		return "deleteConfirm";
	}
//	
//	@RequestMapping(value = "login.do")
//	public String fwdLoginPage(HttpSession session) {
//		return "user/login";
//	}
//	
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
        session.invalidate();
        return "index_final";
    }

	@RequestMapping(value = "loginCheck.do")
	public String loginCheck(UserVO vo, HttpSession session) {
		
		boolean loginSuccess = userService.loginCheck(vo, session);
//		ModelAndView mav = new ModelAndView();
//		
//		mav.setViewName("user/login");
		
		if (loginSuccess) {
			return "index_final";
		} else {
			return "loginFail";
		}
	}
	
	@RequestMapping(value = "addressPopup.do")
	public String fwdAddressPopup() {
		return "address-popup_final";
	}
}
