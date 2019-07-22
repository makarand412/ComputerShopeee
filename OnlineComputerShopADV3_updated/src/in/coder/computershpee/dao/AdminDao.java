package in.coder.computershpee.dao;

import java.sql.SQLException;

import in.coder.computershpee.pojo.Admin;

public interface AdminDao {
	
	public boolean adminLogin(String userName, String Password);
	
	public boolean changePassword(String userName,String newPassword);
	

}