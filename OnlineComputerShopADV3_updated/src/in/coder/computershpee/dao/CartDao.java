package in.coder.computershpee.dao;

import java.util.List;

import in.coder.computershpee.pojo.Cart;
import in.coder.computershpee.pojo.Product;

public interface CartDao {
	
	boolean addToCart(Cart cart);//Customer
	
	boolean deleteCartById(int cartId);//Customer
	
	boolean editCart(int cartId, int quantity);//Customer
	
	Cart searchCartByCartId(int cartId);//admin
	
	List<Cart> viewCart(int customerId);//Customer
	
	boolean clearAllCart();//Admin IMPLEMENTATION NOT WRITTEN YET
	
	boolean clearCartByCustomerId(int customerId);//Customer
	
	

}
