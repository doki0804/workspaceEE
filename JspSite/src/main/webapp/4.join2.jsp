<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("4.form2.jsp");
		return;
	}
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String address = request.getParameter("addr");
	String gender = request.getParameter("gender");
	String job = request.getParameter("job");
	String[] hobbies = request.getParameterValues("hobby");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
<style type='text/css'>
table{
	width: 500px;
	margin: 10px auto 0px auto;
}
td, tr, th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h3 align='center'>가입정보결과</h3>

	<table width='50%'>
		<tr>
			<th width='30%'>항목</th>
			<th width='50%'>입력값</th>
			<th width='20%' >비고</th>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=id %></td>
		<%if(hobbies == null) {%>
			<td rowspan=7></td>
		<%}else {%>
			<td rowspan=<%=hobbies.length+7 %>></td>
		<%} %>
		</tr>
		<tr>
			<td>패쓰워드</td>
			<td><%=password %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=name %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=address %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=gender %></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><%=job %></td>
		</tr>
		<tr>
		<%if(hobbies == null){ %>
			<td rowspan=1>취미</td>
			<td>취미없음</td>
			</tr>
		<%}else {%>
			<td rowspan=<%=hobbies.length %>>취미</td>
			<%for(String hobby : hobbies){ %>
				<td><%=hobby %></td>
			</tr>
			<%} %>
		<%} %>
		</tr>
	</table>

</body>
</html>