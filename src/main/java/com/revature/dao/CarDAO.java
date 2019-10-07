package com.revature.dao;

import static com.revature.util.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.jdbc.util.ConnectionFactory;
import com.revature.pojo.Car;

public class CarDAO {

	private static Connection conn = ConnectionFactory.getConnection();

	private String schema = "project0_test";

	public Car getCarByVin(String vin) {

		String sql = "select * from " + schema + ".car_table where vin = ?";

		PreparedStatement stmt;

		Car car = new Car();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vin);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				car.setVin(rs.getString(1));
				car.setOwner(rs.getString(2));
				car.setMarketPrice(rs.getDouble(3));
			}

		} catch (SQLException e) {
			trace("username not found");
			e.printStackTrace();
		}

		return car;

	}

	public ResultSet getCarsByUsername(String username) {
		String sql = "select * from " + schema + ".car_table where username = ?";

		PreparedStatement stmt;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			trace("sql exception with getting cars by username");
		}

		return rs;
	}

	public void createCar(Car c) {

		String sql = "insert into " + schema + ".car_table (vin, username, price) values(?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getVin());
			stmt.setString(2, c.getOwner());
			stmt.setDouble(3, c.getMarketPrice());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOwner(Car c, String newOwner) {

		String sql = "update " + schema + ".car_table set owner = ? where vin = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newOwner);
			stmt.setString(2, c.getVin());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCar(String vin) {
		String sql = "delete from " + schema + ".car_table where vin = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, vin);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
