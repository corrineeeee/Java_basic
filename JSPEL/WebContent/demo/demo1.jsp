<%@page import="com.sun.xml.internal.ws.client.RequestContext"%>
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
pageContext.setAttribute("name", "corrine");

//request.setAttribute("name", "puffy");
pageContext.setAttribute("name", "puffy", PageContext.REQUEST_SCOPE);

//session.setAttribute("name", "cora");
pageContext.setAttribute("name", "cora", PageContext.SESSION_SCOPE);

//application.setAttribute("name", "Corrine");
pageContext.setAttribute("name", "Corrine", PageContext.APPLICATION_SCOPE);
%>

<%= pageContext.getAttribute("name") %>
<%= request.getAttribute("name") %>
<%= session.getAttribute("name") %>
<%= application.getAttribute("name") %>
<a href = "/JSPEL/test/test.jsp">change</a>
<%= pageContext.findAttribute("name") %>
</body>
</html>