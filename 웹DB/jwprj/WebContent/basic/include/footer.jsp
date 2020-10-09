<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>footer.jsp: print parameters !!</h3> 
<HR>
<li>Name: <%= request.getParameter("name") %></li>
	<li>Email: <%= request.getParameter("email") %></li>
	<li>Tel: <%= request.getParameter("tel") %></li>
</body>
</html>