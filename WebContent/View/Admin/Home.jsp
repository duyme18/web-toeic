<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang quản trị</title>
</head>
<body>
	<h1>Quản trị</h1>
	<h1><%=session.getAttribute("sessionadmin")%></h1>
	<a href="LogoutController">Đăng xuất</a>
</body>
</html>