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

import in.coder.computershpee.daoimpl.CartDaoImpl;
import in.coder.computershpee.daoimpl.CustomerDaoImpl;
import in.coder.computershpee.daoimpl.ProductDaoImpl;
import in.coder.computershpee.pojo.Cart;
import in.coder.computershpee.pojo.Customer;
import in.coder.computershpee.pojo.Product;

/**
 * Servlet implementation class CommonCartServlet
 */
@WebServlet("/CommonCartServlet")
public class CommonCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
    CartDaoImpl cartDaoImpl = new CartDaoImpl();
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String customerEmail = (String) session.getAttribute("CustomerUser");
		String operation = request.getParameter("action");
		
		if (operation != null && operation.equalsIgnoreCase("addToCart")) 
		{
			Customer customer = customerDaoImpl.viewCustomerByEmail(customerEmail);
			
			int customerId = customer.getCustomerId();
			
			//add to cart
			Cart cart = new Cart();
			cart.setProductId(Integer.parseInt(request.getParameter("productId")));
			cart.setCustId(customerId);
			cart.setQuantity(1);
			
			if(cartDaoImpl.searchCartByContent(cart))
			{
				List<Product> productList = productDaoImpl.viewAllProducts();
				request.setAttribute("productList", productList);
				
				System.out.println("Product Already Added. Cart Quantity Updated");
				request.setAttribute("updateToCartSuccess", "Product Already Added. Cart Quantity Updated");
				
				RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
				rd.forward(request, response);				
			}
			else
			{
				boolean cartAdded = cartDaoImpl.addToCart(cart);
				
				if(cartAdded)
				{
					List<Product> productList = productDaoImpl.viewAllProducts();
					request.setAttribute("productList", productList);
					
					System.out.println("Product Added to Cart Successfully");
					request.setAttribute("addToCartSuccess", "Product Added to Cart Successfully");
					
					RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
					rd.forward(request, response);
				}
				else
				{
					List<Product> productList = productDaoImpl.viewAllProducts();
					request.setAttribute("productList", productList);
					
					System.out.println("Problem While Adding ! Try Again !");
					request.setAttribute("addToCartFailed", "Problem While Adding ! Try Again !");
					
					RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
					rd.forward(request, response);
				}
			}			
		}
		
		else if(operation != null && operation.equalsIgnoreCase("showCart"))
		{
			Customer customer = customerDaoImpl.viewCustomerByEmail(customerEmail);
			
			int customerId = customer.getCustomerId();
			
			List<Cart> cartList = cartDaoImpl.viewCart(customerId);
			
			request.setAttribute("CartList", cartList);
			RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
		}
		else if(operation != null && operation.equalsIgnoreCase("edit"))
		{
			int cartId =(int) Integer.parseInt(request.getParameter("cartId"));
			
			Cart cart = cartDaoImpl.searchCartByCartId(cartId);
			
			System.out.println("cartId From dddbbbbbb : "+cart.getCartId());
			System.out.println("Cart : "+cart);
			
			request.setAttribute("CartObjectToEdit", cart);
			RequestDispatcher rd  = request.getRequestDispatcher("UpdateCart.jsp");
			rd.forward(request, response);
		}
		else if(operation != null && operation.equalsIgnoreCase("delete") )
		{
			int cartId = (int) Integer.parseInt(request.getParameter("cartId"));
			
			
			Customer customer = customerDaoImpl.viewCustomerByEmail(customerEmail);
			
			int customerId = customer.getCustomerId();
			
			boolean cartDeleted = cartDaoImpl.deleteCartById(cartId);
			
			if(cartDeleted)
			{
				List<Cart> cartList = cartDaoImpl.viewCart(customerId);
				request.setAttribute("CartList", cartList);
				
				request.setAttribute("CartDeleteSucess", "Product deleted from cart sucessully");
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
			else
			{
				List<Cart> cartList = cartDaoImpl.viewCart(customerId);
				request.setAttribute("CartList", cartList);
				
				request.setAttribute("CartDeleteFailed", "Product deleted Failed");
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("inside post");
		
		String operation = (String) request.getParameter("action");
		System.out.println("operation : "+operation);
		
		if(operation != null && operation.equalsIgnoreCase("editCart"))
		{
			/*Cart cart = new Cart();
			cart.setCartId(Integer.parseInt(request.getParameter("cartId")));
			cart.setProductId(Integer.parseInt(request.getParameter("productId")));
			cart.setCustId(Integer.parseInt(request.getParameter("customerId")));
			cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			*/
			boolean cartUpdated = cartDaoImpl.editCart(Integer.parseInt(request.getParameter("cartId")), Integer.parseInt(request.getParameter("quantity")));
			System.out.println("cartUpdated : "+cartUpdated);
			
			if(cartUpdated)
			{
				System.out.println("AFTER CART UPDATE");
				request.setAttribute("CartUpdateSuccess", "Cart updated successfully");
				List<Cart> cartList = cartDaoImpl.viewCart(Integer.parseInt(request.getParameter("customerId")));
				request.setAttribute("CartList", cartList);
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("AFTER CART UPDATE FAILED");
				request.setAttribute("CartUpdateFailed", "Cart updated failed");
				List<Cart> cartList = cartDaoImpl.viewCart(Integer.parseInt(request.getParameter("customerId")));
				request.setAttribute("CartList", cartList);
				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
		}
		
	}

}
