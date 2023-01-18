package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request.do")
public class HttpServletRequestServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String method = request.getMethod();
		String requestURL = request.getRequestURL().toString();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String remoteAddress = request.getRemoteAddr();
		
		/****************************
		 * << query string >> 
		 * 	- 클라이언트가 서버로 요청시데이타를 전송하는방법 
		 * 	- 형식:name1=value1&name2=value2
		 * ex> name=kim&phone=1234&address=seoul
		 * 
		 * 1.GET 요청방식 : request.do?
		 * << query string >> 
		 *  ex>request.do?name=kim&phone=1234&address=kyunggi
		 * 
		 * 2.POST요청방식 : 책에서 볼께요!!!!
		 ****************************/
		//http://localhost/servletSite/request.do?name=kang&phone=909090&address=seoul
		String queryString=request.getQueryString();
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		System.out.println("********************"+remoteAddress+"님이 전송한정보**********************");
		System.out.println("queryString:"+queryString);
		System.out.println("name 파라메타값:"+name);
		System.out.println("phone 파라메타값:"+phone);
		System.out.println("address 파라메타값:"+address);
		System.out.println("**************************************************************************");
		
		out.println("<h1>HttpServletRequest객체</h1><hr>");
		out.println("<ol>");
		out.println("<li>요청메쏘드:"+method+"</li>");
		out.println("<li>요청URL:"+requestURL+"</li>");
		out.println("<li>요청URI:"+requestURI+"</li>");
		out.println("<li>contextPath:"+contextPath+"</li>");
		out.println("<li>remoteAddress:"+remoteAddress+"</li>");
		
		out.println("</ol>");
		
	}

}
