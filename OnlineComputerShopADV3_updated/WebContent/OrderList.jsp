<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="in.coder.computershpee.pojo.Orders"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	<center>
	<%
		List<Orders> listOfAllOrders = (List<Orders>) request.getAttribute("OrdersList");
		
	%>
	<h2>ORDERS</h2>
	<%
		if (listOfAllOrders.isEmpty()) {
			
			out.println("<p style='color:red'><center>NO CUSTOMER ADDED IN DATABASE YET!</center></p>");
		} else{
			
		
	%>
	<table border="1px">
		<tr>
			<th>Orders Id</th>
			<th>Customer Id</th>
			<th>Total Bill</th>
			<th>Orders Date</th>
			<th>Shipping Address</th>
			
		</tr>
		<%
			for (Orders orders : listOfAllOrders) {
		%>
		<tr>
			<td><%=orders.getOrderId() %></td>
			<td><%=orders.getCustId() %></td>
			<td><%=orders.getTotalBill() %></td>
			<td><%=orders.getOrderDate() %></td>
			<td><%=orders.getShippingAddress() %></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} 
	%>
	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>