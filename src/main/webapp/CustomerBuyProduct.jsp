<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.CustomerBean,test.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerBean cust = (CustomerBean)session.getAttribute("cbean");
	ProductBean product = (ProductBean)request.getAttribute("product");
	out.print("Page belongs to Customer : "+cust.getFirstName()+"<br>");
	out.print("Product Code : "+product.getCode()+"<br>"+"Product Name : "+product.getName()+"<br>"+"Product Price : "+product.getPrice()+"<br>"+"Product Quantity : "+product.getQuantity()+"<br>");
	%>
	<form action="buyprod2" method="post">
		<input type="hidden" name="pcode" value=<%=product.getCode()%>>
		RequiredQuantity:<input type="number" name="reqqty" required><br>
		<input type="submit" value="Buy Product">
	</form>
</body>
</html>