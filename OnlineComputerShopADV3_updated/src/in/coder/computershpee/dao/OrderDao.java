package in.coder.computershpee.dao;

import java.util.List;

import in.coder.computershpee.pojo.Orders;

public interface OrderDao {
	
	List<Orders> viewAllOrders();//Admin
	
	boolean placeOrder(Orders order);//Customer
	
	boolean cancelOrder(int orderId);//Customer
	
	List<Orders> viewOrder(int customerId);//Customer
	
	public float getTotalBill(int customerId);//Customer
	
}
