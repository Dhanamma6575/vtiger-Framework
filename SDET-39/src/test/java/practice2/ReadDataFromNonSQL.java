package practice2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromNonSQL {

	public static void main(String[] args) throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/family_info", "root", "root");
		
		Statement stat=conn.createStatement();
		String query="insert into family(first_name,last_name,address) values('Dhanamma','Malaghan','Mashal')";
		
		int result=stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("user is created");
		}
		else
		{
			System.out.println("user not created");
		}

		conn.close();
	}

}
