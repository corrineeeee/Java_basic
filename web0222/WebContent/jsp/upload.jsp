<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload here</title>
<script type="text/javascript">
function add(){
	var divs = document.getElementById("div1");
	divs.innerHTML += "<div><input type = 'file' name = 'upload'/><input type = 'button' value = 'del' onclick = 'del(this)'/></div>";
}
function del(who){
	who.parentNode.parentNode.removeChild(who.parentNode);
}
</script>
</head>
<body>
<h1>文件上传</h1>
<form action = "${ pageContext.request.contextPath }/upload" method = "post" enctype = "multipart/form-data">
description <input type = "text" name = "info" /><br/>
upload<input type = "file" name = "upload"/><br/>
<input type = "submit" value = "upload"/>
</form>
<h1>多文件上传</h1>
<form action = " ${ pageContext.request.contextPath }/upload " method = "post" enctype = "multipart/form-data">
<input type = "button" value = "add" onclick="add()"/>
<input type = "submit" value = "upload"/><br/>
<div id = "div1"></div> 
</form>


</body>
</html>