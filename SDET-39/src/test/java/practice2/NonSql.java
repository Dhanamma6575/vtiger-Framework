package practice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSql {

		public static void main(String[] args) throws Throwable  {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_information", "root", "root");
			
			Statement stat=conn.createStatement();
			String Query="insert into student(first_name,last_name,addess)values('dhanamma','shree','nagini')";
			
			int result=stat.executeUpdate(Query);
			
			if(result==1)
			{
				System.out.println("user is created");
			}
			else
			{
				System.out.println("user is not created");
			}
	       conn.close();

	}

}
