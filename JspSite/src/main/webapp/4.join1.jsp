<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		/*
		* GET방식으로 요청이들어오면 리턴
		*/
		response.sendRedirect("4.form1.jsp");
		return;
	}
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("pass");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String gender = request.getParameter("gender");
	String message = request.getParameter("message");
	String[] favorites = request.getParameterValues("favorite");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>가입정보</h1><hr>
	<ul>
		<li>아이디:<%=id %></li>
		<li>패스워드:<%=password %></li>
		<li>이메일 :<%=email1+"@"+email2 %></li>
		<li>성별:<%=gender %></li>
		<li>관심영역
			<ol>
				<%for(String favorite : favorites){%>
					<li><%=favorite %></li>
				<%} %>
			</ol>
		</li>
		<li>가입인사:<%=message %></li>
	
	</ul>
</body>
</html>