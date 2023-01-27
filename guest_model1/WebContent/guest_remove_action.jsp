<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_main.jsp");
		return;
	}
	String guest_no = request.getParameter("guest_no");
	GuestService guestService = new GuestService();
	guestService.removeGuest(Integer.parseInt(guest_no));
	response.sendRedirect("guest_list.jsp");
%>