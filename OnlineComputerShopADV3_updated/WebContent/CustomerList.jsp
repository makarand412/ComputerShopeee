<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="in.coder.computershpee.pojo.Customer"%>
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
		List<Customer> listOfAllCustomer = (List<Customer>) request.getAttribute("CustomerList");
		String adminEmail = (String) session.getAttribute("AdminUser");
		/* String customerEmail = (String) session.getAttribute("CustomerUser");

		String ProductDeleteFailed = (String) request.getAttribute("ProductDeleteFailed");
		String ProductDeleteSucess = (String) request.getAttribute("ProductDeleteSucess");

		if (ProductDeleteFailed != null) {
			out.println("<p style='color:red'>" + ProductDeleteFailed + "</p>");
		} else if (ProductDeleteSucess != null) {
			out.println("<p style='color:green'>" + ProductDeleteSucess + "</p>");
		} */
	%>
	<h2>CUSTOMERS</h2>
	<%
		if (listOfAllCustomer.isEmpty()) {
			out.println("<p style='color:red'><center>NO CUSTOMER ADDED IN DATABASE YET!</center></p>");
		} else {
		
	%>
	<table border="1px">
		<tr>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Customer User Name (Email Id)</th>
			<th>Customer Address</th>
			<th>Customer Contact</th>
		</tr>
		<%
			for (Customer customer : listOfAllCustomer) {
		%>
		<tr>
			<td><%=customer.getCustomerId() %></td>
			<td><%=customer.getCustName() %></td>
			<td><%=customer.getUserName() %></td>
			<td><%=customer.getCustAddress() %></td>
			<td><%=customer.getCustContact() %></td>
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