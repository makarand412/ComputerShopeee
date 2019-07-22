package in.coder.computershpee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import in.coder.computershpee.daoimpl.CustomerDaoImpl;
import in.coder.computershpee.pojo.Address;
import in.coder.computershpee.pojo.Customer;
import in.coder.computershpee.pojo.Product;

/**
 * Servlet implementation class CommonCustomerServlet
 */
@WebServlet("/CommonCustomerServlet")
public class CommonCustomerServlet extends HttpServlet {
	
	CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	Customer customer = null;
	Address address = null;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String customerEmail = (String) session.getAttribute("CustomerUser");
		String adminEmail =(String) session.getAttribute("AdminUser");
		
		String operation = request.getParameter("action");
		
		if(operation != null && operation.equalsIgnoreCase("showCustomers"))
		{
			List<Customer> customerList = customerDaoImpl.showAllCustomer();
			request.setAttribute("CustomerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
		}
		else if (operation != null && operation.equalsIgnoreCase("editProfile")) 
		{
			Customer customer = customerDaoImpl.viewCustomerByEmail(customerEmail);
			request.setAttribute("CustomerObjectToEdit", customer);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
			rd.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String customerEmail =(String) session.getAttribute("CustomerUser");
		
		String operation=request.getParameter("action");
		
		if(operation != null && operation.equalsIgnoreCase("Registration"))
		{
			Customer customer = new Customer();
			
			customer.setCustName(request.getParameter("CustomerName"));
			customer.setUserName(request.getParameter("UserName"));
			customer.setPassword(request.getParameter("Password"));
			customer.setCustContact(request.getParameter("ContactNumber"));
			
			Address address = new Address();
			
			address.setStreet(request.getParameter("AddressStreet"));
			address.setArea(request.getParameter("AddressArea"));
			address.setCity(request.getParameter("AddressCity"));
			address.setPincode(request.getParameter("AddressPincode"));
			
			customer.setCustAddress(address);
				
			//String email =	customer.getUserName();
			String email = request.getParameter("UserName");
			
			if (customerDaoImpl.viewCustomerByEmail(email)==null) {
				
				if (customerDaoImpl.custRegistar(customer))
				{
					
					request.setAttribute("customerRegistered","Registration successfully");
					RequestDispatcher rd = request.getRequestDispatcher("CommonLogin.jsp");
					rd.forward(request, response);
				} 
				else
				{	
					request.setAttribute("customerRegistered"," Failed to Register ! try Again!");
					RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
					rd.forward(request, response);
				}			
			}
			else
			{	
				request.setAttribute("customerRegisteredAlready","Customer Already Registered With this Email Id");
				RequestDispatcher rd = request.getRequestDispatcher("CommonLogin.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation != null && operation.equalsIgnoreCase("editCustomer"))
		{
			Customer customer = new Customer();
			
			customer.setCustomerId(Integer.parseInt(request.getParameter("CustomerId")));
			customer.setCustName(request.getParameter("CustomerName"));
			customer.setUserName(request.getParameter("UserName"));
			customer.setPassword(request.getParameter("Password"));
			customer.setCustContact(request.getParameter("ContactNumber"));
			
			Address address = new Address();
			
			address.setStreet(request.getParameter("AddressStreet"));
			address.setArea(request.getParameter("AddressArea"));
			address.setCity(request.getParameter("AddressCity"));
			address.setPincode(request.getParameter("AddressPincode"));
			
			customer.setCustAddress(address);
			
			boolean customerUpdated = customerDaoImpl.editProfile(customer);
			
			if(customerUpdated)
			{
				System.out.println("AFTER CUSTOMER UPDATE");
				request.setAttribute("CustomerUpdateSuccess", "Customer Profile Updated Successfully");
				//List<Product> productList = productaoimpl.viewAllProducts();
				//request.setAttribute("productList", productList);
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("AFTER CUSTOMER UPDATE FAILED");
				request.setAttribute("CustomertUpdateFailed", "Customer Profile Update failed");
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}			
		}		
	}
}
