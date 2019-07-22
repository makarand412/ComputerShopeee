<%@page import="in.coder.computershpee.pojo.Customer"%>
<%@page import="in.coder.computershpee.pojo.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		Customer customer = (Customer) request.getAttribute("CustomerObjectToEdit");
		Address address = customer.getCustAddress();
	%>
	<h2>Edit Profile</h2>
	<form action="CommonCustomerServlet" method="post">
		<input type="hidden" name="action" value="editCustomer">
		<table border="1">
			<tr>
				<td>Customer Id :</td>
				<td><input type="text" name="CustomerId" id="CustomerId" value="<%=customer.getCustomerId()  %>" readonly="readonly" required /></td>
			</tr>
			<tr>
				<td>Customer Name :</td>
				<td><input type="text" name="CustomerName" id="CustomerName" value="<%=customer.getCustName()  %>" required /></td>
			</tr>
			<tr>
				<td>User Name(Email Id) :</td>
				<td><input type="text" name="UserName" id="UserName" value="<%=customer.getUserName() %>" required /></td>
			</tr>
			<tr>	
				<td>Contact Number :</td>
				<td><input type="text" name="ContactNumber" id="ContactNumber" value="<%=customer.getCustContact() %>" required /></td>
			</tr>
			<tr>
				<td>Address Street</td>
				<td><input type="text" name="AddressStreet" id="AddressStreet" value="<%=address.getStreet() %>" required /></td>
			</tr>
			<tr>
				<td>Address Area</td>
				<td><input type="text" name="AddressArea" id="AddressArea" value="<%=address.getArea() %>" required /></td>
			</tr>
			<tr>
				<td>Address City</td>
				<td><input type="text" name="AddressCity" id="AddressCity" value="<%=address.getCity() %>" required /></td>
			</tr>
			<tr>
				<td>Address Pincode</td>
				<td><input type="text" name="AddressPincode" id="AddressPincode" value="<%=address.getPincode() %>" required /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>