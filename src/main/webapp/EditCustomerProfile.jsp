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
	%>
	
	<form action="updatecust" method="post">
		Address:<input type="text" name="addr" value=<%=cust.getAddress()%>><br>
		MailId:<input type="text" name="mail" value=<%=cust.getMailId()%>><br>
		PhoneNumber<input type="text" name="phno" value=<%=cust.getPhoneNumber()%>><br>
		<input type="submit" value="Update">
	</form>
</body>
</html>