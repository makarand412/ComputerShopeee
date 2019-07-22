<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Common Login</title>
</head>
<body style="padding: 10px;">
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	<center>
	<%
		String customerRegistered = (String) request.getAttribute("customerRegistered");
		String customerRegisteredAlready = (String) request.getAttribute("customerRegisteredAlready");

		if (customerRegisteredAlready != null) {
	%>
	<p style="color: red"><%=customerRegisteredAlready%></p>

	<%
		}
	%>
	<%
		if (customerRegistered != null) {
	%>
	<p style="color: green"><%=customerRegistered%></p>

	<%
		}
	%>
	<form action="CommonLoginServlet" method="post">
		<h2>Welcome to Login</h2>
		<table>
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="userName" id="userName" required /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" id="password"
					required /></td>
			</tr>
			<tr>
				<td>User Type:</td>
				<td><input type="radio" name="userType" value="ADMIN">Admin
				<input type="radio" name="userType" value="CUSTOMER">Customer</td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
				<td><input type="reset" value="Clear" /></td>
			</tr>
		</table>
	</form>
	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>