package io.ztech.music.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {
	public static Logger logger = Logger.getLogger(DBUtil.class.getName());
	private Connection connection;

	public void setConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "zilkeradmin");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "Error in making connection");
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Access error");
		} finally {
			
		}
	}

	public Connection getConnection() {
		this.setConnection();
		return this.connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.WARNING, "error in connection closing");
			}
		}
	}

}
