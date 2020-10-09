<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html> 
<head>
<TITLE>include directive example</TITLE></HEAD>
<BODY>
<div align="CENTER">
<H2>include directive example</H2>
<HR>

<%@ include file="menu.jsp" %>
<P>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<td><font size=-1><%@include file="news.jsp" %></font></td>
		<td width="20">&nbsp;</td>
		<td><font size=-1><%@include file="shopping.jsp" %></font></td>
	</tr>	
</table>

</div>
</BODY>
</HTML>