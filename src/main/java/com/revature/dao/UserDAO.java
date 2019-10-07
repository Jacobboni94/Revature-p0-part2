package com.revature.dao;

import static com.revature.util.LoggerUtil.trace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.jdbc.util.ConnectionFactory;
import com.revature.pojo.User;

public class UserDAO {

	private static Connection conn = ConnectionFactory.getConnection();

	private String schema = "project0_test";

	public User getUserByUsername(String username) {

		String sql = "select * from " + schema + ".user_table where username = ?";

		PreparedStatement stmt;

		User user = new User();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setType(rs.getString(3));
			}

		} catch (SQLException e) {
			trace("username not found");
		}

		return user;

	}

	public void createUser(User u) {

		String sql = "insert into " + schema + ".user_table (username, password, type) values(?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getType());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void preparedUpdatePassword(User u) {

		String sql = "update " + schema + ".user_table set password = ? where username = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getPassword());
			stmt.setString(2, u.getUsername());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean usernameTaken(String username) {
		String sql = "select * from " + schema + ".user_table where username = ?";

		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return false;
			}
			else {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}