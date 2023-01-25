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
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("address");
		
		Address address = new Address(Integer.parseInt(no),name,phone,addr);
		
		AddressService addressService = new AddressService();
		addressService.update(address);
		response.sendRedirect("address_detail.jsp?no="+no);
		
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("address_main.jsp");
	}



%>