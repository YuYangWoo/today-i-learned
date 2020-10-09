<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP Basic Examples</title>
</head>
<body>
	<h2>JSP Basic Examples</h2>
	<hr>
	<h3>1. comment <!-- JSP comment: this text will not shown in browser --></h3>
	<%!
	String[] members = {"James", "Martin", "Kim", "Hong"};
	int num1 = 10;
	int calc(int num2) {
		return num1+num2;
	}
	%>

<h3>2. calc(10) method result: <%=calc(10) %></h3>
<h3>3. include: helllo.jsp</h3>
<%@include file="hello.jsp" %> <!-- 지시어 -->
<h4>4. print all members</h4>
<ul>
<%
 for(String s : members ) {
	 %>
	<li><%=s %></li>
	<%  
 }
%>
</ul>
</body>
</html>