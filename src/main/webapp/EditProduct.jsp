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
	ProductBean product = (ProductBean)request.getAttribute("Product");
	out.print("Page belongs to "+admin.getFirstName()+"<br>");
	%>
	<form action="update" method="post">
		<input type="hidden" name="code" value=<%=product.getCode()%>>
		Price:<input type="number" name="price" value=<%=product.getPrice()%>><br>
		Quantity:<input type="number" name="qty" value=<%=product.getQuantity()%>><br>
		<input type="submit" value="UpdateProduct">
	</form>
</body>
</html>