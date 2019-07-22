package in.coder.computershpee.daoimpl;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static in.coder.computershpee.utility.DBConnection.getConnection;//static import

import in.coder.computershpee.dao.AdminDao;
import in.coder.computershpee.pojo.Admin;
import static in.coder.computershpee.utility.GetHash.stringToHash;


public class AdminDaoImpl implements AdminDao {
	
	Connection con =null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	
	@Override
	public boolean adminLogin(String userName, String Password) {
		// TODO Auto-generated method stub
		con = getConnection();
		
		try
		{
			pstmt = con.prepareStatement("select * from admin where username=? and password=?");
			pstmt.setString(1, userName.trim());
			pstmt.setString(2, stringToHash(Password.trim()));
			
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println("WAS NOT ABBLE TO QUERY ADMIN TABLE!, CHECK QUERY");
		}
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("WAS NOT ABLE TO PARSE PASSWORD");
		}
		return false;
	}

	@Override
	public boolean changePassword(String userName,String newPassword) {
		// TODO Auto-generated method stub
		System.out.println("INSIDE CHANGE PASSWORD");
		
			con=getConnection();
			try {
				
				
				pstmt=con.prepareStatement("update admin set password=? where username=?");
				pstmt.setString(1, stringToHash(newPassword.trim()));
				pstmt.setString(2,userName.trim());
				
				int passwordUpdated=pstmt.executeUpdate();
				
				if(passwordUpdated>0)
				{
					return true;
				}
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				//System.out.println("WAS NOT ABBLE TO QUERY ADMIN TABLE!, CHECK QUERY");
			}
			catch (NoSuchAlgorithmException e) {
				// TODO: handle exception
				e.printStackTrace();
				//System.out.println("WAS NOT ABLE TO PARSE PASSWORD");
			
		}
		return false;
	}

}
