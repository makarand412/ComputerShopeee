<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="in.coder.computershpee.pojo.Cart"%>
<%@ page import="java.util.List" import="in.coder.computershpee.pojo.Product"%>
<%@ page import="java.util.List" import="in.coder.computershpee.pojo.Customer"%>
<%@ page import="java.util.List" import="in.coder.computershpee.daoimpl.ProductDaoImpl"%>
<%@ page import="java.util.List" import="in.coder.computershpee.daoimpl.OrderDaoImpl"%>
<%@ page import="java.util.List" import="in.coder.computershpee.daoimpl.CustomerDaoImpl"%>
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
		List<Cart> listOfAllCarts = (List<Cart>) request.getAttribute("CartList");
		String customerEmail = (String) session.getAttribute("CustomerUser");
		
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		CustomerDaoImpl	customerDaoImpl	=	new CustomerDaoImpl();
		Customer customer = customerDaoImpl.viewCustomerByEmail(customerEmail);
		int customerId = customer.getCustomerId();
		float totalBill;
		
		//Cart Update message print
		String CartUpdateSuccess = (String) request.getAttribute("CartUpdateSuccess");
		String CartUpdateFailed = (String) request.getAttribute("CartUpdateFailed");

		if (CartUpdateSuccess != null) {
			
			out.println("<p style='color:green; text-align:center; padding-top:15px; font-size:15px;'>" + CartUpdateSuccess + "</p>");
			
		} else if (CartUpdateFailed != null) {
			
			out.println("<p style='color:red; text-align:center; padding-top:15px; font-size:15px;'>" + CartUpdateFailed + "</p>");
		}
		
		//Cart deleted message print
		String CartDeleteSucess = (String) request.getAttribute("CartDeleteSucess");
		String CartDeleteFailed = (String) request.getAttribute("CartDeleteFailed");

		if (CartDeleteSucess != null) {
			
			out.println("<p style='color:green; text-align:center; padding-top:15px; font-size:15px;'>" + CartDeleteSucess + "</p>");
			
		} else if (CartDeleteFailed != null) {
			
			out.println("<p style='color:red; text-align:center; padding-top:15px; font-size:15px;'>" + CartDeleteFailed + "</p>");
		}
		
		//Cart list print
		if (listOfAllCarts.isEmpty()) {
			
			out.println("<p style='color:red; text-align:center; padding-top:15px; font-size:15px;'>NO ITEMS ADDED TO CART YET!</p>");
		}  else {
	%>
	<h2>CART</h2>
	<form action="CommonOrderServlet" method="post">
		<input type="hidden" name="action" value="placeOrder" />
		<table border="1px">
			<tr>
				<th>Cart Id</th>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Quantity</th>
				<th>Customer Id</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
			for (Cart cart : listOfAllCarts) {
				int productId = cart.getProductId();
				Product product = productDaoImpl.searchProductsById(productId);
				
			%>
			<tr>				
				<td><%=cart.getCartId() %></td>
				<td><%=cart.getProductId() %></td>
				<th><%=product.getProductName() %></th>
				<th><%=product.getProductPrice()%></th>
				<td><%=cart.getQuantity() %></td>
				<td><%=cart.getCustId() %></td>
				
				 
				
				<td><a href="CommonCartServlet?action=edit&cartId=<%=cart.getCartId()%>">Edit</a></td>
				<td><a href="CommonCartServlet?action=delete&cartId=<%=cart.getCartId()%>">Delete</a></td>
			</tr>
			<%
			}
			totalBill = orderDaoImpl.getTotalBill(customerId);
			%>
			<tr>
				<td colspan="3">Total Bill</td>
				<td colspan="3"><%=totalBill %></td>
			</tr>
		</table>
		<br><br>
		<table>
			<tr>
				<td>Enter Shipping Address :</td>
				<td>
					<textarea rows="5" cols="30" name="ShippingAddress" ></textarea>
				</td>
			</tr>
		</table>
		<br><br>
		<input type="submit" value="Place Order">
	</form>
	
	</center>
	<%			
		}
	%>

	<jsp:include page="Footer.jsp"></jsp:include>
	
	</div>
</body>
</html>