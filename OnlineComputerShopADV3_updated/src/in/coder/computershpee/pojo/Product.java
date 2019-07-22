package in.coder.computershpee.pojo;

public class Product {
	
	private int productId;
	private String productName;
	private double productPrice;
	private String productCategory;
	private String productDescription;
	private String productFeatures;
	private String productBrand;
	private String productReviews;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductFeatures() {
		return productFeatures;
	}
	public void setProductFeatures(String productFeatures) {
		this.productFeatures = productFeatures;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductReviews() {
		return productReviews;
	}
	public void setProductReviews(String productReviews) {
		this.productReviews = productReviews;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + ", productDescription=" + productDescription
				+ ", productFeatures=" + productFeatures + ", productBrand=" + productBrand + ", productReviews="
				+ productReviews + "]";
	}
	
	
	
}
