package in.coder.computershpee.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	static Connection con = null;
	
	public static Connection getConnection()
	{
		if(con!=null)
		{
			return con;
		}
		else{
			
			try {
				Properties props = new Properties();
				
//				FileInputStream fis =  new FileInputStream("DBConnection.props");
//				props.load(fis);
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineComputerShopee","root","root");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("DRIVER LIBRARY REQUIRED NOT FOUND");
				//e.printStackTrace();
			}
			catch(SQLException e)
			{
				System.out.println("CHECK INCORRECT URL / USERNAME / PASSWORD SUBMITTED");
				//e.printStackTrace();
			}
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
			
			return con;
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(getConnection());
		System.out.println(getConnection());
		
	}

}
