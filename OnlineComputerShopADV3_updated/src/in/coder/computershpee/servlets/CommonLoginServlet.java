package in.coder.computershpee.servlets;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.computershpee.daoimpl.AdminDaoImpl;
import in.coder.computershpee.daoimpl.CustomerDaoImpl;
import in.coder.computershpee.pojo.Admin;


@WebServlet("/CommonLoginServlet")
public class CommonLoginServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("Index.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String userType=request.getParameter("userType");
		
		if(userType.equalsIgnoreCase("ADMIN"))
		{
			AdminDaoImpl admindaoimpl=new AdminDaoImpl();
					
			boolean login=admindaoimpl.adminLogin(userName,password);
			System.out.println("ad min log in status "+login);
			if(login)
			{
				HttpSession session = request.getSession();
				session.setAttribute("AdminUser", userName);
				request.setAttribute("AdminLoginSuccess","Welcome to Computer / Laptop Shop : " + userName);
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);				
			}
			else
			{ 
				request.setAttribute("AdminLoginFailed","UserName / Password Not Match ");
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			CustomerDaoImpl customerdaoimpl=new CustomerDaoImpl();
			
			boolean login=customerdaoimpl.custLogin(userName, password);
			System.out.println(" customer  log in status "+login);
			if(login)
			{
				System.out.println("customer log in status "+login);
				HttpSession session = request.getSession();
				session.setAttribute("CustomerUser", userName);
				request.setAttribute("CustomerLoginSuccess","Welcome to Online Computer / Laptop Shop : " + userName);
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("CustomerLoginFailed","UserName / Password Not Match ");
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}		
		}
	}
	
}
