package in.coder.computershpee.daoimpl;
import static in.coder.computershpee.utility.DBConnection.getConnection;
import static in.coder.computershpee.utility.GetHash.stringToHash;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import in.coder.computershpee.dao.CustomerDao;
import in.coder.computershpee.pojo.Address;
import in.coder.computershpee.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	Connection con =null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	Customer customer= null;
	Address address = null;
	
	

	@Override
	public boolean custRegistar(Customer cust) {
		// TODO Auto-generated method stub
		
		String email=cust.getUserName();
		try {
		if(viewCustomerByEmail(email)==null)
		{
			pstmt=con.prepareStatement("insert into customers(customername,customerusername,customerpassword,customeraddress,customercontact) values(?,?,?,?,?)");
			
			pstmt.setString(1,cust.getCustName());
			pstmt.setString(2, cust.getUserName());
			pstmt.setString(3, stringToHash(cust.getPassword().trim()));
			pstmt.setString(4, cust.getCustAddress().toString());
			pstmt.setString(5, cust.getCustContact());
			
			int RecordUpdated=pstmt.executeUpdate();
			if(RecordUpdated>0)
			{
				return true;
			}
		}
		/*else
		{
			//System.out.println("RECORD WITH THIS EMAIL ALREADY EXITS WITH THIS EMAILID");
		}*/
		}	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch ( NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean custLogin(String userName, String password) {
		// TODO Auto-generated method stub
		
		con = getConnection();
		
		try {
			pstmt=con.prepareStatement("select * from customers where customerusername=? and customerpassword=?");
			pstmt.setString(1, userName.trim());
			pstmt.setString(2, stringToHash(password.trim()));
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				//System.out.println("WELLCOME "+rs.getString(2));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> showAllCustomer() {
		// TODO Auto-generated method stub
		
		List<Customer> listOfAllCustomers = new ArrayList<>();
		con = getConnection();
		
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery("select * from customers");
			while(rs.next())
			{
				int customerid=rs.getInt(1);
				String customername=rs.getString(2);
				String customerusername=rs.getString(3);
				String customerpassword = rs.getString(4);
				String customeraddress=rs.getString(5);
				String customercontact=rs.getString(6);
				
				//STORING DATA IN OBJECT
				customer= new Customer();
				
				customer.setCustomerId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setUserName(rs.getString(3));
				customer.setPassword(rs.getString(4));
				
				String addressString = rs.getString(5);
				
				String addressArray[] = addressString.split(",");
				
				Address address = new Address();
				
				address.setStreet(addressArray[0]);
				address.setArea(addressArray[1]);
				address.setCity(addressArray[2]);
				address.setPincode(addressArray[3]);
				
				customer.setCustAddress(address);
				
				customer.setCustContact(rs.getString(6));
				
				listOfAllCustomers.add(customer);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listOfAllCustomers;
	}

	@Override
	public Customer viewCustomerById(int customerId) {
		// TODO Auto-generated method stub
		//Used by admin
		con=getConnection();
		
		try {
			
			pstmt=con.prepareStatement("select * from customers where customerid=?");
			pstmt.setInt(1,customerId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				customer = new Customer();
				
				customer.setCustomerId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setUserName(rs.getString(3));
				customer.setPassword(rs.getString(4));
				
				String addressString = rs.getString(5);
				
				String addressArray[] = addressString.split(",");
				
				Address address = new Address();
				
				address.setStreet(addressArray[0]);
				address.setArea(addressArray[1]);
				address.setCity(addressArray[2]);
				address.setPincode(addressArray[3]);
				
				customer.setCustAddress(address);
				customer.setCustContact(rs.getString(6));
				System.out.println("Address In view Customer by Id : "+address);
				return customer;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer viewCustomerByEmail(String custEmail) {
		// TODO Auto-generated method stub
		
		con=getConnection();
		
		try {
			pstmt=con.prepareStatement("select * from customers where customerusername=?");
			pstmt.setString(1, custEmail.trim());
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				customer = new Customer();
				
				customer.setCustomerId(rs.getInt(1));
				customer.setCustName(rs.getString(2));
				customer.setUserName(rs.getString(3));
				customer.setPassword(rs.getString(4));
				
				String addressString = rs.getString(5);
				
				String addressArray[] = addressString.split(",");
				
				Address address = new Address();
				
				address.setStreet(addressArray[0]);
				address.setArea(addressArray[1]);
				address.setCity(addressArray[2]);
				address.setPincode(addressArray[3]);
				
				customer.setCustAddress(address);
				customer.setCustContact(rs.getString(6));
								
				return customer;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean editProfile(Customer customer) {
		// TODO Auto-generated method stub
		if(customer!=null)
		{
			if(viewCustomerById(customer.getCustomerId()) != null)
			{
				try {
					pstmt=con.prepareStatement("update customers set customername=?,customerusername=?,customeraddress=?,customercontact=? where customerid=?");
					
					pstmt.setString(1, customer.getCustName());
					pstmt.setString(2, customer.getUserName());
					//pstmt.setString(3, stringToHash(customer.getPassword().trim()) );
					pstmt.setString(3, customer.getCustAddress().toString());
					pstmt.setString(4, customer.getCustContact());
					pstmt.setInt(5, customer.getCustomerId());
					
					int RecordUpdated=pstmt.executeUpdate();
					if(RecordUpdated>0)
					{
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("RECORD WITH THIS CUSTOMER ID DOES NOT EXITS");
		}
		return false;
	}

	@Override
	public boolean changePassword(String userName, String newPassword) {
		// TODO Auto-generated method stub
		
		con=getConnection();
		
		try {
				pstmt=con.prepareStatement("update customers set customerpassword=? where customerusername=?");
				pstmt.setString(1, stringToHash(newPassword.trim()));
				pstmt.setString(2, userName.trim());
				
				int passwordUpdated=pstmt.executeUpdate();
				
				if(passwordUpdated>0)
				{
					System.out.println("RECORD PSSWORD UPDATED");
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
}
