package databasetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) throws Exception {
		// step1 load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// step2 create the connection object
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:system/system@localhost:1521:xe");

		System.out.println("connected to DB");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from Customers where cust_city != 'Detroit' ");
		while (rs.next()) {

			int custid = rs.getInt(1);
			String custName = rs.getString(2);
			String addr = rs.getString(3);
			String city = rs.getString(4);
			String state = rs.getString(5);
			String country = rs.getString(7);

			System.out.println(custid + "  " + custName + addr + city + state + country);

		}
		con.close();
	}

}
