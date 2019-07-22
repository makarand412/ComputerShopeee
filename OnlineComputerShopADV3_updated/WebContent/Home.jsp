<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>

<%String adminLogin=(String)request.getAttribute("admin"); 
String customerLogin =(String)request.getAttribute("customer");

if(adminLogin!=null && customerLogin==null)
{
	// admin panel
	%>
	
	<ul>
		<li><a href="commonProductsServlet">VIEW ALL PRODUCTS</a></li>
		<li><a href="commonProductsServlet?opeartion='add' ">ADD PRODUCTS</a></li>
		<li><a href="commonProductsServlet?opeartion='edit' ">EDIT</a></li>
		<li><a href="commonOrdersServlet?opeartion='viewOrders' ">VIEW ALL ORDERS</a></li>
		<li><a href="commonCustomerServlet?opeartion='viewAllCustomers' ">VIEW ALL CUSTOMERS</a></li>
		<li><a href="commonCustomerServlet?opeartion='viewAllCustomersDetails' ">VIEW ALL CUSTOMERS DETAILS</a></li>
	</ul>
	<%
}

else if(adminLogin==null && customerLogin!=null)
{
	// Customer panel
	%>
	
	<ul>
		<li><a href="commonProductsServlet">VIEW ALL PRODUCTS</a></li>
		<li><a href="commonProductsServlet?opeartion='add' ">ADD PRODUCTS</a></li>
		<li><a href="commonProductsServlet?opeartion='edit' ">EDIT PRODUCTS</a></li>
		<li><a href="commonOrdersServlet?opeartion='viewOrders' ">VIEW ALL ORDERS</a></li>
		<li><a href="commonCustomerServlet?opeartion='viewAllCustomers' ">VIEW ALL CUSTOMERS</a></li>
		<li><a href="commonCustomerServlet?opeartion='viewAllCustomersDetails' ">VIEW ALL CUSTOMERS DETAILS</a></li>
	</ul>
	<%
}
else
{
	// admin panel
	%>
	
	<ul>
		<li><a href="commonProductsServlet">VIEW ALL PRODUCTS</a></li>
		<li><a href="commonProductsServlet?opeartion='add' ">EDIT PROFILE</a></li>
		<li><a href="commonProductsServlet?opeartion='edit' ">CHANGE PASSWORD</a></li>
		<li><a href="commonOrdersServlet?opeartion='viewOrders' ">EXIT</a></li>
		<li><a href="commonCustomerServlet?opeartion='viewAllCustomers' ">VIEW ALL CUSTOMERS</a></li>
		<li><a href="commonCustomerServlet?opeartion='viewAllCustomersDetails' ">EXIT</a></li>
	</ul>
	<%
}
%>
</h1>
</body>
</html>