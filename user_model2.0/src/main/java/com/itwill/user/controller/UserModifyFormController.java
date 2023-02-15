package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyFormController implements Controller{
	private UserService userService;
	
	public UserModifyFormController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getSession().getAttribute("sUserId")==null) {
			forwardPath = "redirect:user_main.do";
		}else {
			try {
				User user = userService.findUser((String)request.getSession().getAttribute("sUserId"));
				request.setAttribute("user", user);
				forwardPath = "forward:/WEB-INF/views/user_modify_form.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/user_error.jsp";
			}
		}
		return forwardPath;
	}

}
