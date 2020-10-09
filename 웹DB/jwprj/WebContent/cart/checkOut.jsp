<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check out</title>
</HEAD>
<body>
<div align="center">
<H2>Check Out</H2>
Selected products
<HR>
<jsp:useBean id="productlist"  class="java.util.ArrayList" type="java.util.List<String>" scope="session" />

<c:if test="${fn:length(productlist) == 0}">
	<h3>Your cart is empty!!</h3>
</c:if>
<c:forEach items="${productlist}" var="p">
	${p} <br>
</c:forEach>
<hr>
<%--
	List<String> productlist = (List<String>)session.getAttribute("productlist");
	if(productlist.size() == 0) {
		out.println("<h3>Your cart is empty!!</h3>");
	}
	else {
		for(String productname:productlist) {
			out.println(productname+"<BR>");
		}
	}
--%>
</div>
</body>
</html>