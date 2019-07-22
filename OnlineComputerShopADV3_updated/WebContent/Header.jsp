<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tea and Meal - Free CSS Template</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%
	String adminEmail = (String) session.getAttribute("AdminUser");
	String customerEmail = (String) session.getAttribute("CustomerUser");
%>

<div id="templatemo_header">
	<div id="site_title"></div>
</div>
<!-- end of header -->

<!-- displaying menu depend on user type= No user/Customer/Admin -->
<div id="templatemo_menu">
	<ul>
		<li><a href="Index.jsp"><b>Home</b></a></li>
		<li><a href="CommonProductServlet?action=viewAllProducts"><b>Products</b></a></li>
		<li><a href="SearchProduct.jsp"><b>Search</b></a></li>
		
		<%
			if(customerEmail == null && adminEmail== null){
				// Default panel
		%>
		<li><a href="Registration.jsp"><b>Register</b></a></li>
		<li><a href="CommonLogin.jsp"><b>Login</b></a></li>
		<li><a href="#p"><b>Contact Us</b></a></li>
		<%
		}
			if(customerEmail == null && adminEmail != null){
				// // Admin panel
		%>
		<li><a href="CommonCustomerServlet?action=showCustomers"><b>Show Customers</b></a></li>
		<li><a href="AddProduct.jsp"><b>Add Product</b></a></li>
		<li><a href="CommonOrderServlet?action=showOrders"><b>Show Orders</b></a></li>
		<%
		}
			if(customerEmail != null && adminEmail == null){
				// Customer panel
		%>
		<li><a href="CommonCustomerServlet?action=editProfile"><b>Edit Profile</b></a></li>
		<li><a href="CommonCartServlet?action=showCart"><b>Show Cart</b></a></li>
		<li><a href="CommonOrderServlet?action=myOrders"><b>My Orders</b></a></li>
		<%
		}
			if(customerEmail != null || adminEmail != null){
		%>
		<li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
		<li><a href="CommonLoginServlet"><b>Logout</b></a></li>
		<%
		}
		%>
		
	</ul>
</div>

<!-- end of menu -->
</body>
</html>