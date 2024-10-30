<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean admin = (AdminBean)session.getAttribute("AdminBean");
	String msg = (String)request.getAttribute("message");
	out.print("Page belongs to "+admin.getFirstName()+"<br>");
	out.print(msg+"<br>");
	%>
	<a href="product.html">AddProduct</a><br>
	<a href="view">ViewAllProducts</a><br>
	<a href="logout">Logout</a>	
</body>
</html>