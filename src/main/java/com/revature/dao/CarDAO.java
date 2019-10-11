package com.revature.dao;

import static com.revature.util.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Car> getCarsByUsername(String username) {
		String sql = "select * from " + schema + ".car_table where username = ?";

		PreparedStatement stmt;
		List<Car> cars = new ArrayList<Car>();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Car car = new Car();
				car.setVin(rs.getString(1));
				car.setOwner(rs.getString(2));
				car.setMarketPrice(rs.getDouble(3));
				cars.add(car);
			}
		} catch (SQLException e) {
			trace("sql exception with getting cars by username");
		}

		return cars;
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

		String sql = "call project0_test.update_owner(?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getVin());
			stmt.setString(2, newOwner);
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

	public void updatePrice(Car c, double newPrice) {

		String sql = "update " + schema + ".car_table set price = ? where vin = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, newPrice);
			stmt.setString(2, c.getVin());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
