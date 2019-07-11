<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function changeImg(){
	document.getElementById("img").src="/weblogin1/checkCode?time="+ new Date().getTime();
}
</script>
<title>LOGIN</title>
</head>
<body>
	<form action="/weblogin1/login" method="post">
		<h1>Login</h1>
		<%
			String wrong = "";
			if (request.getAttribute("wrong") != null) {
				wrong = (String) request.getAttribute("wrong");
			}
		%>

		<h3>
			<font color="red"><%=wrong%></font>
		</h3>
		<%
			String checkCodewrong = "";
			if (request.getAttribute("checkCodewrong") != null) {
				checkCodewrong = (String) request.getAttribute("checkCodewrong");
			}
		%>

		<h3>
			<font color="red"><%=checkCodewrong%></font>
		</h3>
		<table border="3px" width="600" style="color: blue;">
			<tr>
				<td>username</td>
				<td><input type="text" name="username" value="${ cookie.ifremember.value }"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>请输入验证码</td>
				<td><input type="text" name="checkCode">
				<img id = "img" src="/weblogin1/checkCode" />
				<a href = "#" onclick = "changeImg()">change pic</a>
				</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="ifremember" value="true"></td>
				<td>是否记住用户名</td>
			<tr>
				<td colspan="2"><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>