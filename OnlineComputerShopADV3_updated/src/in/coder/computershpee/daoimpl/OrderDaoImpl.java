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
import java.util.Random;

import in.coder.computershpee.dao.OrderDao;
import in.coder.computershpee.pojo.Cart;
import in.coder.computershpee.pojo.OrderDetails;
import in.coder.computershpee.pojo.Orders;

public class OrderDaoImpl implements OrderDao {
	
	
	Connection con =getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	Orders order = null;
	
	CartDaoImpl cartdaoimpl= new CartDaoImpl();

	
	
	public List<OrderDetails> viewOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		
		List<OrderDetails> orderDetails = new ArrayList<>();
		
		try {
			pstmt=con.prepareStatement("select * from orderdetails where orderid=?");
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			
			
			while(rs.next())
			{
				OrderDetails orderDetail=new OrderDetails();
				orderDetail.setOrderId(orderId);
				orderDetail.setProductId(rs.getInt(2));
				orderDetail.setQuantity(rs.getInt(3));
				orderDetails.add(orderDetail);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	
	@Override
	public List<Orders> viewAllOrders() {
		// TODO Auto-generated method stub
		
		List<Orders> listAllOrders = new ArrayList<>();
		
		try {
			stmt=con.createStatement();
			rs = stmt.executeQuery("select * from orders");
			
			while(rs.next())
			{
				order = new Orders();
				
				order.setOrderId(rs.getInt(1));
				order.setCustId(rs.getInt(2));
				order.setShippingAddress(rs.getString(3));
				order.setOrderDate(rs.getString(4));
				order.setTotalBill(rs.getFloat(5));
				
				listAllOrders.add(order);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAllOrders;
	}
	
	private boolean checkOrderAlreadyAdded(int orderId)
	{
		try {
			pstmt = con.prepareStatement("select * from orders where orderid=?");
			pstmt.setInt(1, orderId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
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
	public boolean placeOrder(Orders order) {
		// TODO Auto-generated method stub
		
		if(order!=null)
		{
			float totalBill = getTotalBill(order.getCustId());
			int orderId = new Random().nextInt(15000);
			
			while(checkOrderAlreadyAdded(orderId))
			{
				orderId = new Random().nextInt(15000);
			}
			
			try {
				pstmt = con.prepareStatement("insert into orders(orderid, customerid, shippingaddress, orderdate, totalbill) values(?,?,?,?,?)");
				
				pstmt.setInt(1, orderId);
				pstmt.setInt(2, order.getCustId());
				pstmt.setString(3, order.getShippingAddress());
				pstmt.setString(4, new Date().toString());
				pstmt.setFloat(5, totalBill);
				
				
				int recordInserted =pstmt.executeUpdate();
				
				if(recordInserted>0)
				{
					List<Cart> listOfCart = cartdaoimpl.viewCart(order.getCustId());
					
					for(int i=0; i<listOfCart.size(); i++)
					{
						int productId = listOfCart.get(i).getProductId();
						int quantity = listOfCart.get(i).getQuantity();
						insertOrderDetails(orderId,productId,quantity);
						
					}
					
					cartdaoimpl.clearCartByCustomerId(order.getCustId());
					System.out.println(listOfCart);
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public float getTotalBill(int customerId)
	{
		float totalBill = 0;
		
		try {
			pstmt = con.prepareStatement("select sum(c.quantity*p.productprice) from carts c, products p where c.productid=p.productid and c.customerid=?");
			pstmt.setInt(1, customerId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				totalBill = rs.getFloat(1);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalBill;
	}
	
	private boolean insertOrderDetails(int orderId,int productId,int quantity)
	{
		try {
			pstmt = con.prepareStatement("insert into orderdetails(orderid, productid, quantity) values(?,?,?)");
			
			pstmt.setInt(1, orderId);
			pstmt.setInt(2, productId);
			pstmt.setInt(3, quantity);
			
			int recordInserted =pstmt.executeUpdate();
			if(recordInserted>0)
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
	public boolean cancelOrder(int orderId) {
		// TODO Auto-generated method stub
		
		try {
			pstmt = con.prepareStatement("delete from orders where orderid=?");
			pstmt.setInt(1, orderId);
			
			int recordDeleted = pstmt.executeUpdate();			
			if(recordDeleted>0)
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
	public List<Orders> viewOrder(int customerId) {
		// TODO Auto-generated method stub
		
		List<Orders> myOrderList = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement("select * from orders where customerid=?");
			pstmt.setInt(1, customerId);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				order = new Orders();
				order.setOrderId(rs.getInt(1));
				order.setCustId(rs.getInt(2));
				order.setShippingAddress(rs.getString(3));
				order.setOrderDate(rs.getString(4));
				order.setTotalBill(rs.getFloat(5));
				
				myOrderList.add(order);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myOrderList;
	}
	
}
