package in.coder.computershpee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.computershpee.daoimpl.CustomerDaoImpl;
import in.coder.computershpee.daoimpl.OrderDaoImpl;
import in.coder.computershpee.pojo.Customer;
import in.coder.computershpee.pojo.OrderDetails;
import in.coder.computershpee.pojo.Orders;

/**
 * Servlet implementation class CommonOrderServlet
 */
@WebServlet("/CommonOrderServlet")
public class CommonOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderDaoImpl OrderDaoImpl = new OrderDaoImpl();
	CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String adminEmail =(String) session.getAttribute("AdminUser");
		String customerEmail =(String) session.getAttribute("CustomerUser");
		
		String operation = request.getParameter("action");
		
		if(operation != null && operation.equalsIgnoreCase("showOrders"))
		{
			List<Orders> ordersList = OrderDaoImpl.viewAllOrders();
			request.setAttribute("OrdersList", ordersList);
			RequestDispatcher rd = request.getRequestDispatcher("OrderList.jsp");
			rd.forward(request, response);
		}
		else if(operation != null && operation.equalsIgnoreCase("myOrders"))
		{
			Customer customer = customerDaoImpl.viewCustomerByEmail(customerEmail);
			int customerId = customer.getCustomerId();
			
			List<Orders> myOrdersList = OrderDaoImpl.viewOrder(customerId);
			request.setAttribute("MyOrdersList", myOrdersList);
			RequestDispatcher rd = request.getRequestDispatcher("MyOrdersList.jsp");
			rd.forward(request, response);
		}
		else if(operation != null && operation.equalsIgnoreCase("orderDetails"))
		{
			List<OrderDetails> orderDetail=OrderDaoImpl.viewOrderDetails(Integer.parseInt(request.getParameter("orderId")));
			
			
			request.setAttribute("orderDetail", orderDetail);
			RequestDispatcher rd = request.getRequestDispatcher("OrderDetails.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String customerEmail =(String) session.getAttribute("CustomerUser");
		
		String operation=request.getParameter("action");
		
		if(operation != null && operation.equalsIgnoreCase("placeOrder"))
		{
			Customer customer = customerDaoImpl.viewCustomerByEmail(customerEmail);
			
			int customerId = customer.getCustomerId();
			System.out.println("customerId :" +customerId);
			Orders orders = new Orders();
			
			orders.setCustId(customerId);
			orders.setShippingAddress(request.getParameter("ShippingAddress"));
			
			boolean orderPlaced = OrderDaoImpl.placeOrder(orders);
			
			if (orderPlaced)
			{
				request.setAttribute("OrderPlaceSuccess","Order Placed Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			} 
			else
			{	
				request.setAttribute("OrderPlaceFailed"," Failed to Place Order ! Try Again!");
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
