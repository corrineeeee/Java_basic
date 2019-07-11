<%@ page import="domain.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if (request.getSession().getAttribute("existuser") == null) {
	%>
	<h1>
		Havent arrived please go <a href="/weblogin1/login.jsp">login</a>
		first
	</h1>
	<%
		} else {
	%>
	<h1>Success!</h1>
	<h1>Hello</h1>
	<%
		user newuser = (user) request.getSession().getAttribute(
					"existuser");
	%>

	<font size="6"><%=newuser.getNickname()%></font>
	<%
		}
	%>
</body>
</html>