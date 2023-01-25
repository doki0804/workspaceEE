<%@page import="com.itwill.address.Address"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		if(request.getMethod().equalsIgnoreCase("GET")){
			response.sendRedirect("address_main.jsp");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("address");
		
		Address newAddress = new Address(0,name,phone,addr);
		
		AddressService addressService = new AddressService();
		addressService.insert(newAddress);
		
		response.sendRedirect("address_main.jsp");
		
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("address_main.jsp");
	}
	
	
%>