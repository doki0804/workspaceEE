package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.mvc.Controller;

/*
 * - 클라이언트요청한개를 처리하는 비즈니스로직을 담고있는 객체
 * - DispatcherServlet객체가 호출하는 handleRequest메쏘드를가짐
 * - handleRequest메쏘드가호출되면 DispatcherServlet객체에 forwardPath를 반환해줌
 */
public class GuestModifyActionController implements Controller {
	private GuestService guestService;
	
	public GuestModifyActionController() {
		guestService = new GuestService();
	}
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:guest_main.do";
		}else {
			try {
				String guest_no = request.getParameter("guest_no");
				String guest_name = request.getParameter("guest_name");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_email = request.getParameter("guest_email");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				Guest guest = new Guest(Integer.parseInt(guest_no),guest_name,null,guest_homepage,guest_email,guest_title,guest_content);
				guestService.updateGuest(guest);
				request.setAttribute("guest",guest);
				forwardPath = "redirect:guest_view.do?guest_no="+guest_no;
			} catch (Exception e) {
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		return forwardPath;
	}
}
