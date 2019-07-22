package in.coder.computershpee.dao;

import java.util.List;

import in.coder.computershpee.pojo.Product;

public interface ProductDao {
	
	boolean addProduct(Product product);//admin
	
	boolean editProduct(Product product);//admin
	
	boolean deleteProduct(int productId);//admin
	
	Product searchProductsById(int productId);//admin
	
	List<Product> searchProductsByName(String productName);//Customer
	
	List<Product> searchProductsByBrand(String productBrand);//Customer
	
	List<Product> searchProductsByCategory(String productCategory);//Customer
	
	List<Product> viewAllProducts();//Customer/admin
	
	boolean addReviews(int productId);//Customer
	
	List <Product> searchProductByPrice(String productCategory, float sPrice, float ePrice);//Customer

}
