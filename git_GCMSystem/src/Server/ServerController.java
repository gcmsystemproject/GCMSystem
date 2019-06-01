package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerController{
	static Connection conn;

	public static void ConnectDB() 
	{
		try 
		{
            Class.forName("com.mysql.jc.jdbc.Driver");
        } catch (Exception ex) {/* handle the error*/}
        
        try 
        {
        	conn = DriverManager.getConnection("jdbc:mysql://localhost/gcmsystem?serverTimezone=IST","root","Aa123456");
            System.out.println("SQL connection succeed");
     	} catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
   	}
}