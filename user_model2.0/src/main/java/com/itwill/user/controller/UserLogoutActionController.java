package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.UserService;

public class UserLogoutActionController implements Controller{
	private UserService userService;
	
	public UserLogoutActionController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getSession().getAttribute("sUserId")==null) {
			forwardPath = "redirect:user_main.do";
		}
		request.getSession().invalidate();
		forwardPath="redirect:user_main.do";
		return forwardPath;
	}

}
