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
	out.print("Page belongs to Customer : "+cust.getFirstName()+"<br>");
	out.print(cust.getFirstName()+"&nbsp;&nbsp;&nbsp;"+cust.getLastName()+"&nbsp;&nbsp;&nbsp;"+cust.getAddress()+"&nbsp;&nbsp;&nbsp;"+cust.getMailId()+"&nbsp;&nbsp;&nbsp;"+cust.getPhoneNumber()+"&nbsp;&nbsp;&nbsp;"+"<a href='editcust'>Edit</a>"+"<br>");
	%>
	<a href="custlogout">Logout</a>
</body>
</html>