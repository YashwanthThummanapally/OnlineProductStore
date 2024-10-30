<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerBean cust = (CustomerBean)session.getAttribute("cbean");
	ArrayList<ProductBean> products = (ArrayList<ProductBean>)session.getAttribute("productlist");
	out.print("Page belongs to Customer : "+cust.getFirstName()+"<br>");
	
	Iterator<ProductBean> itr = products.iterator();
	while(itr.hasNext()) {
		ProductBean product = itr.next();
		out.print(product.getCode()+"&nbsp;&nbsp;&nbsp;"+product.getName()+"&nbsp;&nbsp;&nbsp;"+product.getPrice()+"&nbsp;&nbsp;&nbsp;"+product.getQuantity()+"&nbsp;&nbsp;&nbsp;"+"<a href='buyprod?pcode="+product.getCode()+"'>Buy</a><br>");
	}
	%>
	<a href="custlogout">Logout</a>	
</body>
</html>