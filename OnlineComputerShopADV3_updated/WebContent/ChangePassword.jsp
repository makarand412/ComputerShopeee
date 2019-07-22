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
			<div class="container">
				
				<form action="ChangePasswordServlet" method="post">
					<h2>CHANGE PASSWORD</h2>
					<table>
						<tr>
							<td> Old Password :</td>
							<td><input type="password" name="OldPassword" id="OldPassword" required /></td>
						</tr>	
						<tr>
							<td> New Password :</td>
							<td><input type="password" name="NewPassword" id="NewPassword" required /></td>
						</tr>
						<tr>
							<td> Confirm Password :</td>
							<td><input type="password" name="ConfirmPassword" id="ConfirmPassword" required /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Save" /></td>
						</tr>
					</table>
				</form>
			</div>
		</center>	
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>