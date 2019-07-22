<%@page import="in.coder.computershpee.daoimpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" import="in.coder.computershpee.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

	<%
		List<OrderDetails> listOfMyAllOrders = (List<OrderDetails>) request.getAttribute("orderDetail");
		
	%>
	<h2><center>ORDER LIST</center></h2>
	<%
		if (listOfMyAllOrders.isEmpty()) {
			
			out.println("<p style='color:red'><center>NO CUSTOMER ADDED IN DATABASE YET!</center></p>");
		} else{
			
		
	%>
	<table border="1px" align="center">
		<tr>
			<th>Orders Id</th>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Quantity</th>
		</tr>
		<%
			for (OrderDetails orders : listOfMyAllOrders) {
		%>
		<tr>
			<td><%=orders.getOrderId() %></td>
			<td><%=new ProductDaoImpl().searchProductsById(orders.getProductId()).getProductId() %></td>
		<td><%=new ProductDaoImpl().searchProductsById(orders.getProductId()).getProductName() %></td>
			<td><%=new ProductDaoImpl().searchProductsById(orders.getProductId()).getProductPrice() %></td>
			<td><%=orders.getQuantity() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} 
	%>

	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>