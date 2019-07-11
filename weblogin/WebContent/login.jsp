<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>
	<form action="/weblogin/login" method="post">
		<h1>Login</h1>
		<%
			String wrong = "";
			if (request.getAttribute("wrong") != null) {
				wrong = (String) request.getAttribute("wrong");
			}
		%>
		
		<h3><font color="red"><%=wrong%></font></h3>
		
		<table border="3px" width="600" style="color: blue;">
			<tr>
				<td>username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>