<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-up Results</title>
</head>
<body>
	<H2>Sign-up Results</H2>
	<HR>
	<ul>
		<li>Name: <%=request.getParameter("username")%></li>
		<li>Job: <%=request.getParameter("job")%></li>
		<li>Favorites:
		<ul>
		<c:forEach items="${paramValues.hobby}" var="hobby">
			<li>${hobby}</li>
		</c:forEach>
	<%--
		// getParameterValues 메서드를 이용해 "favorite" 로 설정된 form 의 체크박스 값들을 모두 읽어옴.
		String hobbies[] = request.getParameterValues("hobby");

		for (String hobby : hobbies) {
			out.println("<li>" + hobby + "</li>");
		}
	--%>
		</ul>
		</li>
	</ul>
	<hr>
	<H2>Request Information</H2>
	1. Client IP Address : <%=request.getRemoteAddr()%> <br>
	2. Request Method : <%=request.getMethod()%>
	
	<H2>Response Information</H2>
	1. Status Code : <%=response.getStatus()%> <br>
	2. Locale: <%=response.getLocale()%>
	<hr>
	
	<H2>Server Information</H2>
	1. Server info : <%=application.getServerInfo() %> <br>
	2. Context Path : <%=application.getContextPath() %>
	<%
		application.log("Log from signupResult.jsp");
	%>
</body>
</html>