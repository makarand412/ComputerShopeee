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

	<%
		List<Orders> listOfMyAllOrders = (List<Orders>) request.getAttribute("MyOrdersList");
		
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
			<th>Customer Id</th>
			<th>Total Bill</th>
			<th>Orders Date</th>
			<th>Shipping Address</th>
			<th>ORDER DETILS</th>
		</tr>
		<%
			for (Orders orders : listOfMyAllOrders) {
		%>
		<tr>
			<td><%=orders.getOrderId() %></td>
			<td><%=orders.getCustId() %></td>
			<td><%=orders.getTotalBill() %></td>
			<td><%=orders.getOrderDate() %></td>
			<td><%=orders.getShippingAddress() %></td>
				<td><a href='CommonOrderServlet?action=orderDetails&orderId=<%=orders.getOrderId() %>'>ORDER DEATISL</</a></td>
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