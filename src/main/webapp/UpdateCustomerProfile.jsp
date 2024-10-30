<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerBean cust = (CustomerBean)session.getAttribute("cbean");
	String msg = (String)request.getAttribute("message");
	out.print("Page belongs to Customer : "+cust.getFirstName()+"<br>");
	out.print(msg+"<br>");
	%>
	<a href="viewcust">ViewProfile</a><br>
	<a href="custlogout">Logout</a>
</body>
</html>