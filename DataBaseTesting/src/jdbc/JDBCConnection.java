package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/selenium_db_testing", "root","Arya@123");
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from employeeInfo where location='Pathanamthitta'");
		while (rs.next()) {
			String data = rs.getString("name");
			System.out.println(data);
		}
	}

}
