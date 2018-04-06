package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgresSQL {

	static Connection con;
	static String url;

	public static Connection getConnection() {

		try {
			String url = "jdbc:postgresql://localhost:5432/LibrarySK";
			// assuming "DataSource" is your DataSource name

			Class.forName("org.postgresql.Driver");

			try {
				con = DriverManager.getConnection(url, "postgres", "timao");

				// assuming your SQL Server's username is "username"
				// and password is "password"

				System.out.println("----------Conectado!------------");

			}

			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		return con;
	}
}