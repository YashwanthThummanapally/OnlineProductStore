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
	int reqQty = Integer.parseInt(request.getParameter("reqqty"));
	out.print("Page belongs to Customer : "+cust.getFirstName()+"<br>");
	out.print("Product Code : "+product.getCode()+"<br>"+"Product Name : "+product.getName()+"<br>"+"Product Price : "+product.getPrice()+"<br>"+"Product Quantity : "+product.getQuantity()+"<br>"+"Required Quantity : "+reqQty+"<br>"+"Bill Amount : "+(reqQty*product.getPrice())+"<br>");	
	%>
	<form action="updateprod" method="post">
		<input type="hidden" name="pcode" value=<%=product.getCode()%>>
		<input type="hidden" name="reqqty" value=<%=reqQty%>>
		<input type="submit" value="Payment">
	</form>
</body>
</html>