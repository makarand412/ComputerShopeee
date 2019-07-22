package in.coder.computershpee.dao;

import java.util.List;

import in.coder.computershpee.pojo.Customer;

public interface CustomerDao {
	
	boolean custRegistar(Customer cust);//Customer
	
	boolean custLogin(String userName, String password);//Customer Remains
	
	List<Customer> showAllCustomer();
	
	Customer viewCustomerById(int customerId);//admin
	
	Customer viewCustomerByEmail(String custEmail);//Customer
	
	boolean editProfile(Customer cust);//Customer Remains
	
	boolean changePassword(String userName, String newPassword);//Customer Remains
	

}
