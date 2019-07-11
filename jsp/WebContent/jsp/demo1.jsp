<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hi corrine</h1>
<h2>jsp的脚本元素</h2>
<%!
//声明标签:变量或者方法声明 
//声明变量eg
int i = 3;
int m = 7;
String name = "corrine";
%>
<%=
//表达式标签
//写在该脚本中的代码,翻译成方法内部的out.print();中的内容
i
%>
<%= m %>
<%= name %>
<%
//程序代码标签:程序代码
//用来写这个脚本中的代码,翻译成方法内部的局部变量或者方法内部代码片段
int b = 6;
String nickname = "C";
%>
<h2>开发中的路径问题之相对路径</h2>
<a href="../../web_test1/web_01">访问web_01相对路径</a>
<h2>绝对路径</h2>
<a href="/web_test1/web_01">访问web_01绝对路径</a>
</body>
</html>