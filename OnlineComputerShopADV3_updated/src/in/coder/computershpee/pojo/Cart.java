package in.coder.computershpee.pojo;

public class Cart {
	
	private int cartId;
	private int custId;
	private int productId;
	private int quantity;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", custId=" + custId + ", productId=" + productId + ", quantity=" + quantity
				+ "]";
	}
	
	
	
}
