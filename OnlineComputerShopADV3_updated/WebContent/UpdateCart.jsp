<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="in.coder.computershpee.pojo.Cart"%>
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
	Cart cart = (Cart) request.getAttribute("CartObjectToEdit");
	%>
	
	<form action="CommonCartServlet" method="post">
		<input type="hidden" name="action" value="editCart" />
		<table border="1" align="center">
			<caption>Update Cart</caption>
			<tr>
				<td>Cart Id :</td>
				<td><input type="text" name="cartId" id="cartId" value="<%=cart.getCartId() %>" readonly="readonly" required /></td>
			</tr>
			<tr>
				<td>Product Id :</td>
				<td><input type="text" name="productId" id="productId" value="<%=cart.getProductId() %>" readonly="readonly" required /></td>
			</tr>
			<tr>
				<td>Customer Id :</td>
				<td><input type="text" name="customerId" id="customerId" value="<%=cart.getCustId() %>" readonly="readonly" required /></td>
			</tr>
			<tr>
				<td>Quantity :</td>
				<td><input type="text" name="quantity" id="quantity" value="<%=cart.getQuantity() %>" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>