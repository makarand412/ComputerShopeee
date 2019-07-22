package in.coder.computershpee.daoimpl;

import static in.coder.computershpee.utility.DBConnection.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.coder.computershpee.dao.CartDao;
import in.coder.computershpee.pojo.Cart;
import in.coder.computershpee.pojo.Product;

public class CartDaoImpl implements CartDao {
	
	Connection con =getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	Cart cart = null;
	

	@Override
	public boolean addToCart(Cart cart) {
		// TODO Auto-generated method stub
		
		if(cart!=null)
		{
			if(searchCartByContent(cart))
			{
				return true;
			}
			else
			{
				try {
					pstmt = con.prepareStatement("insert into carts(productid, customerid, quantity) values(?,?,?)");
					
					pstmt.setInt(1, cart.getProductId());
					pstmt.setInt(2, cart.getCustId());
					pstmt.setInt(3, cart.getQuantity());
					
					int recordInserted =pstmt.executeUpdate();
								
					if(recordInserted>0)
					{
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return false;
	}
	
	public boolean searchCartByContent(Cart cart)
	{
		try {
			pstmt=con.prepareStatement("select cartid,quantity from carts where customerid=? and productid=?");
			pstmt.setInt(1, cart.getCustId());
			pstmt.setInt(2, cart.getProductId());
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				int cartid=rs.getInt(1);
				int quntity=rs.getInt(2);
				int newQuantity=quntity+cart.getQuantity();
				editCart(cartid,newQuantity);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCartById(int cartId) {
		// TODO Auto-generated method stub
		
		try {
			pstmt=con.prepareStatement("delete from carts where cartid=?");
			pstmt.setInt(1,cartId);
						
			int RecordDeleted=pstmt.executeUpdate();
			if(RecordDeleted>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editCart(int cartId, int quantity) {
		// TODO Auto-generated method stub
		
		try {
			pstmt=con.prepareStatement("update carts set quantity=? where cartid=?");
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, cartId);
			
			int RecordUpdated=pstmt.executeUpdate();
			if(RecordUpdated>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> viewCart(int customerId) {
		// TODO Auto-generated method stub
		
		List<Cart> cartList = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement("select * from carts where customerid=?");
			pstmt.setInt(1, customerId);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				cart = new Cart();
				
				cart.setCartId(rs.getInt(1));
				cart.setCustId(rs.getInt(3));
				cart.setProductId(rs.getInt(2));
				cart.setQuantity(rs.getInt(4));
				
				cartList.add(cart);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public boolean clearAllCart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clearCartByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		
		try {
			pstmt=con.prepareStatement("delete from carts where customerid=?");
			pstmt.setInt(1,customerId);
						
			int RecordDeleted=pstmt.executeUpdate();
			if(RecordDeleted>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cart searchCartByCartId(int cartId) {
		// TODO Auto-generated method stub
		
		try {
			
			pstmt=con.prepareStatement("select * from carts where cartid=?");
			pstmt.setInt(1,cartId);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{				  
				Cart cart = new Cart();
				  
				cart.setCartId(rs.getInt(1));
				cart.setProductId(rs.getInt(2));
				cart.setCustId(rs.getInt(3));
				cart.setQuantity(rs.getInt(4));
				
				return cart;  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
