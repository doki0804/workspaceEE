package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserLoginActionController implements Controller {
	private UserService userService;
	public UserLoginActionController() throws Exception{
		userService=new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:user_login_form.do";
		}else {
			try {
				String userId = request.getParameter("userId");
				String password = request.getParameter("password");
				User fUser = new User("","","","");
				int loginResult = userService.login(userId, password);
				if(loginResult == 0) {
					//아이디존재안함
					String msg1 = "아이디가 존재하지 않습니다.";
					fUser.setUserId(userId);
					fUser.setPassword(password);
					request.setAttribute("fUser", fUser);
					request.setAttribute("msg1", msg1);
					forwardPath = "forward:/WEB-INF/views/user_login_form.jsp";
					
				}else if(loginResult == 1) {
					//비밀번호 불일치
					String msg2 = "비밀번호가 틀립니다.";
					fUser.setUserId(userId);
					fUser.setPassword(password);
					request.setAttribute("fUser", fUser);
					request.setAttribute("msg2", msg2);
					forwardPath = "forward:/WEB-INF/views/user_login_form.jsp";
				}else if(loginResult == 2) {
					//로그인성공
					request.getSession().setAttribute("sUserId", userId);
					forwardPath = "redirect:user_main.do";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/user_error.jsp";
			}
		}
		return forwardPath;
	}

}
