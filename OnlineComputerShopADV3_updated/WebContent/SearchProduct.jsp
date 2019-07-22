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

	<form action="CommonProductServlet" method="post">
		<input type="hidden" name="action" value="searchProduct">
		<br>
		<b>&nbsp;&nbsp;&nbsp;&nbsp;Product Name : </b><input type="text" name="productName" />
	
		<input type="submit" value="Serach Product">
	</form>
	
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>