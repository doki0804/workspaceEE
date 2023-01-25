<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		if(request.getMethod().equalsIgnoreCase("GET")){
			response.sendRedirect("address_main.jsp");
			return;
		}
		String no = request.getParameter("no");
		
		AddressService addressService = new AddressService();
		addressService.delete(Integer.parseInt(no));
		response.sendRedirect("address_list.jsp");
		
		
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("address_main.jsp");
	}
%>