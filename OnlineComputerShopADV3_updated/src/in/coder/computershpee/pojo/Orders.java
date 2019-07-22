package in.coder.computershpee.pojo;

import java.util.List;

public class Orders {
	
	private int orderId;
	private int custId;
	private float totalBill;
	private String orderDate;
	private String paymentOptions;
	private int cartId;
	private String shippingAddress;
	private int	quantity;
	
	private List<Product> listOfCartItems;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public float getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentOptions() {
		return paymentOptions;
	}
	public void setPaymentOptions(String paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<Product> getListOfCartItems() {
		return listOfCartItems;
	}
	public void setListOfCartItems(List<Product> listOfCartItems) {
		this.listOfCartItems = listOfCartItems;
	}
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", custId=" + custId + ", totalBill=" + totalBill + ", orderDate="
				+ orderDate + ", paymentOptions=" + paymentOptions + ", cartId=" + cartId + ", shippingAddress="
				+ shippingAddress + ", quantity=" + quantity + ", listOfCartItems=" + listOfCartItems + "]";
	}
	
	
	

}
