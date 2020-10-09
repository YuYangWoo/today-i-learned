<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL core tag examples</h2>
	<hr>
	<!-- set, out -->
<h3>set, out</h3>
<c:set var="product" value="<b>Apple Iphone</b>" />
<c:set var="intArray" value="${[1,2,3,4,5]}" />
<p>
	product name(jstl):
	<c:out value="${product}" default="Not registerd" escapeXml="true" />
</p>
<p>product name(el):${product}</p>
<p>array[2] value: ${intArray[2]}</p>

<hr>
<!-- forEach -->
<h3>forEach Basic</h3>
<ul>
	<li>Print all items in array</li>
	<c:forEach var="num" varStatus="i" items="${intArray}">
		<li>${i.index} : ${num}</li>
	</c:forEach>
</ul>

<hr>
<!--  if -->
<h3>if</h3>
<c:set var="checkout" value="true" />
<c:if test="${checkout}">
	<p>Order: ${product}</p>
</c:if>
<c:if test="${!checkout}">
	<p>No checkout!!</p>
</c:if>

<c:if test="${!empty product}">
	<p>
		<b>${product} Already added!!.</b>
	</p>
</c:if>

<hr>
<!-- choose, when, otherwise  -->
<h3>choose, when, otherwise</h3>
<c:choose>
	<c:when test="${checkout}">
		<p>Order product: ${product}</p>
	</c:when>
	<c:otherwise>
		<p>No Checkout!!</p>
	</c:otherwise>
</c:choose>

<hr>
<!-- forTokens 예 -->
	<h3>forTokens</h3>
	<c:forTokens var="city" items="Seoul|Tokyo|New York|Toronto"
		delims="|" varStatus="i">
		<c:if test="${i.first}">City list : </c:if>
     ${city} 
     <c:if test="${!i.last}">,</c:if>
	</c:forTokens>

	<hr>
</body>
</html>