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
		String customerRegistered = (String) request.getAttribute("customerRegistered");
	

		if (customerRegistered != null) {
	%>
	<p style="color: red"><%=customerRegistered%></p>

	<%
		}
	%>
	<h2>Welcome to Registration</h2>
	<form action="CommonCustomerServlet" method="post">
		<input type="hidden" name="action" value="Registration">
		<table>
			<tr>
				<td>Customer Name :</td>
				<td><input type="text" name="CustomerName" id="CustomerName" pattern="[A-za-z ]{5,15}"  required /></td>
			</tr>
			<tr>
				<td>User Name(Email Id) :</td>
				<td><input type="text" name="UserName" id="UserName" required /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="Password" id="Password" pattern="[a-zA-z0-9]{8,20}" required /></td>
			</tr>
			<tr>	
				<td>Contact Number :</td>
				<td><input type="text" name="ContactNumber" id="ContactNumber" required /></td>
			</tr>
			<tr>
				<td>Address Street</td>
				<td><input type="text" name="AddressStreet" id="AddressStreet" required /></td>
			</tr>
			<tr>
				<td>Address Area</td>
				<td><input type="text" name="AddressArea" id="AddressArea" required /></td>
			</tr>
			<tr>
				<td>Address City</td>
				<td><input type="text" name="AddressCity" id="AddressCity" required /></td>
			</tr>
			<tr>
				<td>Address Pincode</td>
				<td><input type="text" name="AddressPincode" id="AddressPincode" required /></td>
			</tr>
			<br>
			<tr>
				<td><input type="reset" value="Clear" /></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>