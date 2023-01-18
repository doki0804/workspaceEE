package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/join2.do")
public class JoinServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * GET 방식으로 요청이 들어오면 05-03.form2.html로 방향재지정 (redirection)
		 */
		response.sendRedirect("05-03.form2.html");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		/*
		 * 1.파라메타받기
		 */
	
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] hobbies  = request.getParameterValues("hobby");
		/*
		 * 2.Service객체 가입메쏘드호출
		 */
		/*
		 * 3.클라이언트로 응답 출력
		 */

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("<style type='text/css'>");
		out.println("td, tr, th {");
		out.println("	border: 1px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h3 align='center'>가입정보결과</h3>");
		out.println("<center><table width='50%'>");
		out.println("		<tr>");
		out.println("			<th width='30%'>항목</th>");
		out.println("			<th width='50%'>입력값</th>");
		out.println("			<th width='20%' >비고</th>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>아이디</td>");
		out.println("			<td>"+id+"</td>");
		if(hobbies == null) {
			out.println("			<td rowspan='7'></td>");
		}else {
			out.println("			<td rowspan='"+(hobbies.length+7)+"'></td>");
		}
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>패쓰워드</td>");
		out.println("			<td>"+pass+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>이름</td>");
		out.println("			<td>"+name+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>주소</td>");
		out.println("			<td>"+addr+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>성별</td>");
		out.println("			<td>"+gender+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<td>직업</td>");
		out.println("			<td>"+job+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		if(hobbies == null) {
			out.println("			<td rowspan='1'>취미</td>");
			out.println("			<td>취미없음</td>");
			out.println("		</tr>");
		}else {
			out.println("			<td rowspan='"+hobbies.length+"'>취미</td>");
			for(String hobby : hobbies) {
					out.println("<td>"+hobby+"</td>");
					out.println("		</tr>");
			}
		}
		out.println("	</table></center>");
		out.println("</body>");
		out.println("</html>");
	}
	    
}