<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="in.coder.computershpee.pojo.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Product</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	<center>
	<%
	Product product = (Product) request.getAttribute("ProductObjectToEdit");
	%>
	<h2>Edit Product</h2>
	<form action="CommonProductServlet" method="post">
		<input type="hidden" name="action" value="editProduct" />
		<table border="2px">
			<tr>
				<td>Product Id :</td>
				<td><input type="text" name="productId" id="productId" value="<%=product.getProductId() %>" readonly="readonly" required /></td>
			</tr>
			<tr>
				<td>Product Name :</td>
				<td><input type="text" name="productName" id="productName" value="<%=product.getProductName() %>" required /></td>
			</tr>
			<tr>
				<td>Product Price :</td>
				<td><input type="text" name="productPrice" id="productPrice" value="<%=product.getProductPrice() %>" required /></td>
			</tr>
			<tr>
				<td>Product Category :</td>
				<td><select name="productCategory" value="<%=product.getProductCategory() %>" required />
						<option value="<%=product.getProductCategory() %>"><%=product.getProductCategory() %></option>
						<option value="Desktop">Desktop</option>
						<option value="Laptop">Laptop</option>
						<option value="Mouse">Mouse</option>
						<option value="Cabinet">Cabinet</option>
						<option value="GamingConsole">Gaming Console</option>
				</select></td>
			</tr>
			<tr>
				<td>Product Description :</td>
				<td><textarea rows="3" cols="20" name="productDescription"   required><%=product.getProductDescription() %></textarea></td>
			</tr>
			<tr>
				<td>productFeatures :</td>
				<td><textarea rows="3" cols="20" name="productFeatures"  required><%=product.getProductFeatures() %></textarea></td>
			</tr>
			<tr>
				<td>Product Brand :</td>
				<td><select name="productBrand" value="<%=product.getProductBrand() %>" required />
						<option value="<%=product.getProductBrand() %>"><%=product.getProductBrand() %></option>
						<option value="DELL">DELL</option>
						<option value="HP">HP</option>
						<option value="SONY">SONY</option>
						<option value="LENOVO">LENOVO</option>
						<option value="ASUS">ASUS</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>