package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserModifyActionController implements Controller {
	private UserService userService;
	
	public UserModifyActionController() throws Throwable {
		userService = new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		
		try {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:user_error.do";
			}else {
				String password = (String)request.getParameter("password");
				String name = (String)request.getParameter("name");
				String email = (String)request.getParameter("email");
				User user = new User((String)request.getSession().getAttribute("sUserId"),password,name,email);
				userService.update(user);
				forwardPath="redirect:user_view.do";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/user_error.jsp";
		}
		return forwardPath;
	}

}
