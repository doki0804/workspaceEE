package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_remove_action.do")
public class GuestRemoveActionServlet extends HttpServlet {
	private GuestService guestService;

	public GuestRemoveActionServlet() throws Exception {
		guestService = new GuestService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = "";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:"+request.getContextPath();
			}else {
				String guest_noStr = request.getParameter("guest_no");
				guestService.delete(Integer.parseInt(guest_noStr));
				forwardPath = "redirect:guest_list.do";
			}
		} catch (Exception e) {
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}

		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];

		if (forwardOrRedirect.equals("redirect")) {
			// redirect
			response.sendRedirect(path);
		} else {
			// forwarding
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
