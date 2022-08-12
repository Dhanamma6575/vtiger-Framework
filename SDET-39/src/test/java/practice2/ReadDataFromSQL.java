package practice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromSQL {

	public static void main(String[] args) throws Throwable  {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/family_info", "root", "root");
		
		Statement stat=conn.createStatement();
		String selectQuery="select * from family";
		
		ResultSet result=stat.executeQuery(selectQuery);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
       conn.close();
	}

}
