package com.itwill.summer.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveAction;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;

/*
 * 1. 클라이언트(웹브라우져)의 모든요청을 받는 서블릿작성(front Controller)
 * 2. 확장자가 *.do인 모든클라이언트의 요청이 서블릿을 실행하도록 web.xml에 url pattern mapping
   << web.xml >>
    <servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>com.itwill.summer.mvc.DispatcherServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
 */

public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * <<요청 url(command)>> /guest_main.do /guest_list.do /guest_view.do
		 * /guest_write_form.do /guest_write_action.do /guest_modify_form.do
		 * /guest_modify_action.do /guest_remove_action.do
		 */
		/*
		 * 1.DispatcherServlet이 클라이언트의 요청 URI를 사용해서 요청을 분석
		 */
		String command = request.getRequestURI().substring(request.getContextPath().length());
		/*
		 * 2-1.DispatcherServlet이 클라이언트 요청에 따른 controller객체 생성
		 */
		String forwardPath = "";
		Controller controller = null;
		if (command.equals("/guest_main.do")) {
			/******* guest_main.do를 처리하는 Controller 객체생성 *******/
			controller = new GuestMainController();
			
		} else if (command.equals("/guest_list.do")) {
			/****** guest_list.do를 처리하는 Controller 객체생성 ******/
			controller = new GuestListController();
					
		} else if (command.equals("/guest_view.do")) {
			/****** guest_view.do를 처리하는 Controller 객체생성 ******/
			controller = new GuestViewController();
			
		} else if (command.equals("/guest_write_form.do")) {
			/****** guest_write.do를 처리하는 Controller 객체생성 ******/
			controller = new GuestWriteFormController();
			
		} else if (command.equals("/guest_write_action.do")) {
			/****** guest_write_action.do를 처리하는 Controller 객체생성 ******/
			controller = new GuestWriteActionController();
			
		} else if (command.equals("/guest_modify_form.do")) {
			/****** guest_modify_form.do를 처리하는 Controller 객체생성 ******/
			controller = new GuestModifyFormController();
			
		} else if (command.equals("/guest_modify_action.do")) {
			/****** guest_modify_action.do를 처리하는 Controller 객체생성 ******/
			controller = new GuestModifyActionController();
						
		} else if (command.equals("/guest_remove_action.do")) {
			/****** guest_remove_action.do를 처리하는 Controller 객체생성 ******/
			controller = new GuestRemoveAction();
			
		} else {
			controller = new GuestErrorController();
			
		}
		/*
		 * 2-2.DispatcherServlet이 Controller 객체의 handleRequest 메쏘드 실행
		 * 2-3.DispatcherServlet이 Controller 객체의 handleRequest메쏘드 실행 반환값이 forwardPath를 받는다.
		 */
		forwardPath = controller.handleRequest(request, response);
		/*
		 * 3.DispatcherServlet이 forwardPath를 사용해서 forward 혹은 redirect를 한다.
		 */
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
