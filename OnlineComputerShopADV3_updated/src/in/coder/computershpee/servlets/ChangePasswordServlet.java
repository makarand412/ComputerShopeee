package in.coder.computershpee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import in.coder.computershpee.daoimpl.AdminDaoImpl;
import in.coder.computershpee.daoimpl.CustomerDaoImpl;
import in.coder.computershpee.pojo.Admin;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	
	AdminDaoImpl adminDaoImpl=new AdminDaoImpl();
	CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String adminEmail =(String) session.getAttribute("AdminUser");
		String customerEmail =(String) session.getAttribute("CustomerUser");
		
		String oldPassword = request.getParameter("OldPassword");
		String newPassword = request.getParameter("NewPassword");
		
		System.out.println("111adminEmail"+adminEmail);
		
		if (customerEmail != null) {
			// for customer change password

			boolean isOldPasswordTrue = customerDaoImpl.custLogin(customerEmail, oldPassword);

			if (isOldPasswordTrue) {
				boolean passwordUpdated = customerDaoImpl.changePassword(customerEmail, newPassword);

				if (passwordUpdated) {
					request.setAttribute("PasswordChangeSuccess", "Password Changed Successfully");
					request.getSession().invalidate();
					RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("PasswordChangeFailed", "Failed to Change Password ! try Again!");
					RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("PasswordChangeFailed", "Failed to Change Password ! try Again! Old Password is not currect");
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
		}
		
		else if (adminEmail != null) {
			
			System.out.println("adminEmail"+adminEmail);
			// for ADMIN change password
			
			boolean isOldPasswordTrue = adminDaoImpl.adminLogin(adminEmail, oldPassword);

			if (isOldPasswordTrue) {
				
				boolean passwordUpdated = adminDaoImpl.changePassword(adminEmail, newPassword);
				System.out.println("passwordUpdated : "+passwordUpdated);
				
				if (passwordUpdated) {
					request.setAttribute("PasswordChangeSuccess", "Password Changed Successfully");
					request.getSession().invalidate();
					RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("PasswordChangeFailed", "Failed to Change Password ! try Again!");
					RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("PasswordChangeFailed", "Failed to Change Password ! try Again! Old Password is not currect");
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
			
		}
		
		
	}
	
	

}
