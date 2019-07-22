package in.coder.computershpee.pojo;

public class Otp {
	
	private String userName;
	private String OTP;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
	@Override
	public String toString() {
		return "Otp [userName=" + userName + ", OTP=" + OTP + "]";
	}
	
	
	
	

}
