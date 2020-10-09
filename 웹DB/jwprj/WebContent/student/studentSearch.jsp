<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student search</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/student">
Student ID: <input type="text" name="id"><input type="submit" value="Search">
</form>
</body>
</html>