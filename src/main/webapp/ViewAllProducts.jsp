<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean admin = (AdminBean)session.getAttribute("AdminBean");
	ArrayList<ProductBean> products = (ArrayList<ProductBean>)session.getAttribute("Products");
	out.print("Page belongs to "+admin.getFirstName()+"<br>");
	
	Iterator<ProductBean> it = products.iterator();
	while(it.hasNext()) {
		ProductBean product = it.next();
		out.print(product.getCode()+"&nbsp;&nbsp;&nbsp;&nbsp"+product.getName()+"&nbsp;&nbsp;&nbsp;&nbsp"+product.getPrice()+"&nbsp;&nbsp;&nbsp;&nbsp"+product.getQuantity()+"&nbsp;&nbsp;&nbsp;&nbsp"+"<a href='edit?pcode="+product.getCode()+"'>Edit</a>"+"&nbsp;&nbsp;&nbsp;&nbsp"+"<a href='delete?pcode="+product.getCode()+"'>Delete</a>"+"<br>");
	}
	%>
	<a href="logout">Logout</a>
</body>
</html>