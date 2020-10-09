<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Product select</title>
<meta charset="UTF-8">
<%
	request.setCharacterEncoding("UTF-8");
	session.setAttribute("username",request.getParameter("username"));
%>
<body>
<div align="center">
	<H2>Product List</H2>
	<HR>
	Welcome !! <%=session.getAttribute("username") %>
	<HR>
	<form name="form1" method="POST" action="cart.jsp">
		<SELECT name="product">
			<option>Apple</option>
			<option>Orange</option>
			<option>Pineapple</option>
			<option>Lemon</option>
			<option>Banana</option>
		</SELECT>
		<input type="submit" value="Add"/>
	</form>
	<a href="checkOut.jsp">Check Out</a>
</div>
</body>
</html>