package in.coder.computershpee.servlets;

import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.coder.computershpee.daoimpl.ProductDaoImpl;
import in.coder.computershpee.pojo.Product;

@WebServlet("/CommonProductServlet")
public class CommonProductServlet extends HttpServlet {
	
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("inside get");
		
		String operation = request.getParameter("action");
		
		if(operation != null && operation.equalsIgnoreCase("edit") )
		{
			int productId =(int) Integer.parseInt(request.getParameter("productId"));
			
			Product product = productDaoImpl.searchProductsById(productId);
			request.setAttribute("ProductObjectToEdit", product);
			RequestDispatcher rd  = request.getRequestDispatcher("UpdateProduct.jsp");
			rd.forward(request, response);
		}
		
		else if(operation != null && operation.equalsIgnoreCase("delete") )
		{
			int productId = (int) Integer.parseInt(request.getParameter("productId"));
			
			if(productDaoImpl.deleteProduct(productId))
			{
				List<Product> productList = productDaoImpl.viewAllProducts();
				request.setAttribute("productList", productList);
				
				request.setAttribute("ProductDeleteSucess", "Product deleted sucessully");
				RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
				rd.forward(request, response);
			}
			else
			{
				List<Product> productList = productDaoImpl.viewAllProducts();
				request.setAttribute("productList", productList);
				
				request.setAttribute("ProductDeleteFailed", "Product deleted Failed");
				RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
				rd.forward(request, response);
			}			
		}
		else if(operation != null && operation.equalsIgnoreCase("viewAllProducts") )
		{
			List<Product> productList = productDaoImpl.viewAllProducts();
			request.setAttribute("productList", productList);
			
			RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("inside post");
		
		String operation = (String) request.getParameter("action");
		System.out.println("operation : "+operation);
		
		if(operation != null && operation.equalsIgnoreCase("editProduct"))
		{
			Product product = new Product();
			product.setProductId(Integer.parseInt(request.getParameter("productId")));
			product.setProductName(request.getParameter("productName"));
			product.setProductPrice(Double.parseDouble(request.getParameter("productPrice")));
			product.setProductCategory(request.getParameter("productCategory"));
			product.setProductDescription(request.getParameter("productDescription"));
			product.setProductFeatures(request.getParameter("productFeatures"));
			product.setProductBrand(request.getParameter("productBrand"));
			
			boolean productUpdated = productDaoImpl.editProduct(product);
			System.out.println("productUpdated : "+productUpdated);
			
			if(productUpdated)
			{
				System.out.println("AFTER PRODUCT UPDATE");
				request.setAttribute("ProductUpdateSuccess", "Product updated successfully");
				List<Product> productList = productDaoImpl.viewAllProducts();
				request.setAttribute("productList", productList);
				RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("AFTER PRODUCT UPDATE FAILED");
				request.setAttribute("ProductUpdateFailed", "Product updated failed");
				List<Product> productList = productDaoImpl.viewAllProducts();
				request.setAttribute("productList", productList);
				RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation != null && operation.equalsIgnoreCase("searchProduct") )
		{
			String productName=request.getParameter("productName").trim();
		
			List<Product> productList = 	productDaoImpl.searchProductsByName(productName);
			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
			rd.forward(request, response);
			
		}
		else if(operation != null && operation.equalsIgnoreCase("addProduct"))
		{
			Product product = new Product();
			product.setProductName(request.getParameter("productName"));
			product.setProductPrice(Double.parseDouble(request.getParameter("productPrice")));
			product.setProductCategory(request.getParameter("productCategory"));
			product.setProductDescription(request.getParameter("productDescription"));
			product.setProductFeatures(request.getParameter("productFeatures"));
			product.setProductBrand(request.getParameter("productBrand"));
			
			if (!productDaoImpl.productIsAlreadyAdded(product)) {

				boolean productAdded = productDaoImpl.addProduct(product);
				if (productAdded) {
				
					request.setAttribute("AddProductSuccess", "Product Added Sucessully");
					RequestDispatcher rd = request.getRequestDispatcher("AddProduct.jsp");
					rd.forward(request, response);

				} else {
					request.setAttribute("AddProductFailed", "Problem in Adding Product ! Try Again !");
					RequestDispatcher rd = request.getRequestDispatcher("AddProduct.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("ProductAlreadyAdded", "Problem in Adding Product ! Try Again ! Product Already Added !");
				RequestDispatcher rd = request.getRequestDispatcher("AddProduct.jsp");
				rd.forward(request, response);
			}
		}
	}
}
