package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserLogoutActionController implements Controller{
	private UserService userService;
	
	public UserLogoutActionController() throws Exception {
		userService = new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";

		request.getSession().invalidate();
		forwardPath="redirect:user_main.do";
		return forwardPath;
	}

}
