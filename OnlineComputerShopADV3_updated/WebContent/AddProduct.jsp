<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
</head>
<body>
	<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	<center>
	<%
	String AddProductSuccess =(String) request.getAttribute("AddProductSuccess");
	String AddProductFailed =(String) request.getAttribute("AddProductFailed");
	String ProductAlreadyAdded =(String) request.getAttribute("ProductAlreadyAdded");
	
	
	if(AddProductSuccess != null)
	{
		
		out.println("<p style='color:green'>"+AddProductSuccess+"</p>");
	}
	else if(AddProductFailed != null)
	{
		
		out.println("<p style='color:red'>"+AddProductFailed+"</p>");
	}
	else if(ProductAlreadyAdded != null)
	{
		
		out.println("<p style='color:red'>"+ProductAlreadyAdded+"</p>");
	}
	%>
	<h2>Add Product</h2>
	<form action="CommonProductServlet" method="post">
		<input type="hidden" name="action" value="addProduct" />
		<table border="1">
			<tr>
				<td>Product Name :</td>
				<td><input type="text" name="productName" id="productName" required /></td>
			</tr>
			<tr>
				<td>Product Price :</td>
				<td><input type="text" name="productPrice" id="productPrice" required /></td>
			</tr>
			<tr>
				<td>Product Category :</td>
				<td><select name="productCategory" required>
					<option value="SelectCategory">Select Category</option>
					<option value="Desktop">Desktop</option>
					<option value="Laptop">Laptop</option>
					<option value="Mouse">Mouse</option>
					<option value="Cabinet">Cabinet</option>
					<option value="GamingConsole">Gaming Console</option>				
				</select></td>
			</tr>
			<tr>
				<td>Product Description :</td>
				<td><textarea rows="5" cols="20" name="productDescription" required></textarea></td>
			</tr>
			<tr>
				<td>productFeatures :</td>
				<td><textarea rows="5" cols="20" name="productFeatures"  required></textarea></td>
			</tr>
			<tr>
				<td>Product Brand :</td>
				<td><select name="productBrand" required>
				<option value="SelectBrand">Select Brand</option>
				<option value="Apple">Apple</option>
				<option value="HP">HP</option>
				<option value="SONY">SONY</option>
				<option value="DELL">DELL</option>
				<option value="LENOVO">LENOVO</option>
				<option value="ASUS">ASUS</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="AddProduct" /></td>
				<td><input type="reset" value="Clear" /></td>
			</tr>
		</table>
	</form>
	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>