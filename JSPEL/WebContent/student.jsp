<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>
</head>
<body>
<h1>student table</h1>
<table border = "1px" width="600">
	<tr>
		<td>id</td>
		<td>name</td>
		<td>sex</td>
	</tr>
	<c:forEach var = "student" items = "${ list }" >
		<tr>
			<td>${ student.id }</td>
			<td>${ student.name }</td>
			<td>${ student.sex }</td>
		</tr>
	</c:forEach>



</table>
</body>
</html>