<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="in.coder.computershpee.pojo.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PRODUCTS</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	<center>
	<%
		List<Product> listOfAllProducts = (List<Product>) request.getAttribute("productList");
		String adminEmail = (String) session.getAttribute("AdminUser");
		String customerEmail = (String) session.getAttribute("CustomerUser");

		//Product deleted message print
		String ProductDeleteFailed = (String) request.getAttribute("ProductDeleteFailed");
		String ProductDeleteSucess = (String) request.getAttribute("ProductDeleteSucess");

		if (ProductDeleteSucess != null) {
			
			out.println("<p style='color:green; text-align:center; padding-top:15px; font-size:15px;'>" + ProductDeleteSucess + "</p>");
		
		} else if (ProductDeleteFailed != null) {
			
			out.println("<p style='color:red; text-align:center; padding-top:15px; font-size:15px;'>" + ProductDeleteFailed + "</p>");
			
		}
		
		//Product update message print
		String ProductUpdateSuccess = (String) request.getAttribute("ProductUpdateSuccess");
		String ProductUpdateFailed = (String) request.getAttribute("ProductUpdateFailed");

		if (ProductUpdateSuccess != null) {
			
			out.println("<p style='color:green; text-align:center; padding-top:15px; font-size:15px;'>" + ProductUpdateSuccess + "</p>");
		
		} else if (ProductUpdateFailed != null) {
			
			out.println("<p style='color:red; text-align:center; padding-top:15px; font-size:15px;'>" + ProductUpdateFailed + "</p>");
		}
		
		////Product add to cart message print
		String updateToCartSuccess =(String) request.getAttribute("updateToCartSuccess");
		String addToCartSuccess =(String) request.getAttribute("addToCartSuccess");
		String addToCartFailed =(String) request.getAttribute("addToCartFailed");
		
		if(updateToCartSuccess != null)
		{
			out.println("<p style='color:green; text-align:center; padding-top:15px; font-size:15px;'>" + updateToCartSuccess + "</p>");
		}
		else if(addToCartSuccess != null)
		{
			out.println("<p style='color:green; text-align:center; padding-top:15px; font-size:15px;'>" + addToCartSuccess + "</p>");
		}
		else if(addToCartFailed != null)
		{
			out.println("<p style='color:red; text-align:center; padding-top:15px; font-size:15px;'>" + addToCartFailed + "</p>");
		}
		
		
		
	%>
	<h2>PRODUCTS</h2>
	<%
		if (listOfAllProducts.isEmpty()) {
			out.println("<p style='color:red'><center>NO PRODUCTS ADDED IN DATABASE YET!</center></p>");

		} else {
	%>
	<table border="1px">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Category</th>
			<th>Product Brand</th>
			<%
				if (adminEmail != null) {
			%>
			<th>Edit</th>
			<th>Delete</th>
			<%
				}
			%>
			<%
				if (customerEmail != null) {
			%>
			<th>Add To Cart</th>
			<%
				}
			%>
		</tr>
		<%
			for (Product product : listOfAllProducts) {
		%>
		<tr>
			<td><%=product.getProductId()%></td>
			<td><%=product.getProductName()%></td>
			<td><%=product.getProductPrice()%></td>
			<td><%=product.getProductCategory()%></td>
			<td><%=product.getProductBrand()%></td>
			<%
				if (adminEmail != null) {
			%>
			<td><a href="CommonProductServlet?action=edit&productId=<%=product.getProductId()%>">Edit</a></td>
			<td><a href="CommonProductServlet?action=delete&productId=<%=product.getProductId()%>">Delete</a></td>
			<%
				}
			%>
			<%
				if (customerEmail != null) {
			%>
			<td><a
				href="CommonCartServlet?action=addToCart&productId=<%=product.getProductId()%>">Add
					To Cart</a></td>
			<%
				}
			%>
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