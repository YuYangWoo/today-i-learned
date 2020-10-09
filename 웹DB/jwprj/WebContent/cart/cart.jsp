<jsp:useBean id="productlist"  class="java.util.ArrayList" type="java.util.List<String>" scope="session"/>
<%
	String productname = request.getParameter("product");
	productlist.add(productname);
%>
<script>
	alert("<%=productname %> added to cart !!");
	history.go(-1);
</script>