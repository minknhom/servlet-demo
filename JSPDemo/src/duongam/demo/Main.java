package duongam.demo;

import java.sql.Connection;
import java.sql.SQLException;

import duongam.connection.ConnectionUtils;

public class Main {

	public static void main(String[] args) {
		Connection conn;
		try {
			conn = ConnectionUtils.getConnection();
			if (conn == null) {
				System.out.println("Error");
			} else {
				System.out.println("Success");
				System.out.println(conn);
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
