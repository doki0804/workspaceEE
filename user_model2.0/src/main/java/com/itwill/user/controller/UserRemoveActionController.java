package com.itwill.user.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserRemoveActionController implements Controller {
	private UserService userService;
	
	public UserRemoveActionController() throws Exception {
		userService = new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		
		try {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath="redirect:user_main.do";
			}else {
				request.setCharacterEncoding("UTF-8");
				userService.remove((String)request.getSession().getAttribute("sUserId"));
				request.getSession().invalidate();
				forwardPath="redirect:user_main.do";
			}
		} catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}

}
