package in.coder.computershpee.pojo;

public class Customer extends Person{
	
	private int customerId;
	private String custName;
	private String custContact;
	private Address custAddress;
	private String verified;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustContact() {
		return custContact;
	}
	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}
	public Address getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(Address custAddress) {
		this.custAddress = custAddress;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custName=" + custName + " UserName=" + super.getUserName() + " Password=" + super.getPassword() + ", custContact=" + custContact
				+ ", custAddress=" + custAddress + ", verified=" + verified + "]";
	}
	
	
	
	
	
	
	

}
