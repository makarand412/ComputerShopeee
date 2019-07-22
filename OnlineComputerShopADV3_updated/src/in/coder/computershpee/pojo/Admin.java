package in.coder.computershpee.pojo;

public class Admin extends Person {
	
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + " UserName=" + super.getUserName() + " Password=" + super.getPassword() + "]";
	}

}
