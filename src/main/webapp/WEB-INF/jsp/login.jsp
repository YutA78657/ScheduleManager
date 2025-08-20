<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%  String error = (String)request.getAttribute("error");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h4>まぐろの気晴れや</h4>
<h2>シフト管理</h2>
<%if(!(error == null)){%>
	<p><%=error%></p>
<%}%>
<form action = "login" method = "post">
	<p>ID</p>
	<input type = "text" name = "id"><br>
	<p>パスワード</p>
	<input type = "text" name = "pass"><br><br>
	<input type = "submit" value = "ログイン">
	
</form>
</body>
</html>