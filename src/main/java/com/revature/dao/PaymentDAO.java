package com.revature.dao;

import static com.revature.util.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.jdbc.util.ConnectionFactory;
import com.revature.pojo.Payment;

public class PaymentDAO {

	private static Connection conn = ConnectionFactory.getConnection();

	private String schema = "project0_test";

	public Payment getPaymentByID(String paymentID) {

		String sql = "select * from " + schema + ".payment_table where payment_id = ?";

		PreparedStatement stmt;

		Payment payment = new Payment();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paymentID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				payment.setPayment_id(rs.getString(1));
				payment.setUsername(rs.getString(2));
				payment.setVin(rs.getString(3));
				payment.setAmount(rs.getDouble(4));
			}

		} catch (SQLException e) {
			trace("sql exception in get payment by id");
		}

		return payment;

	}

	public void createPayment(Payment p) {

		String sql = "insert into " + schema + ".payment_table (payment_id, username, vin, amount) values(?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getPayment_id());
			stmt.setString(2, p.getUsername());
			stmt.setString(3, p.getVin());
			stmt.setDouble(4, p.getAmount());
			stmt.executeUpdate();
		} catch (SQLException e) {
			trace("sql exception in create payment");
		}
	}

	public List<Payment> getPaymentsByVin(String vin) {
		String sql = "select * from " + schema + ".payment_table where vin = ?";
		List<Payment> payments = new ArrayList<Payment>();
		PreparedStatement stmt;
		Payment payment = new Payment();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vin);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				payment.setPayment_id(rs.getString(1));
				payment.setUsername(rs.getString(2));
				payment.setVin(rs.getString(3));
				payment.setAmount(rs.getDouble(4));
				payments.add(payment);
			}
		} catch (SQLException e) {
			trace("sql exception in get payments by vin");
		}
		return payments;
	}
	
	public List<Payment> getPaymentsByUsername(String username){
		String sql = "select * from " + schema + ".payment_table where username = ?";
		List<Payment> payments = new ArrayList<Payment>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,  username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Payment payment = new Payment();
				payment.setPayment_id(rs.getString(1));
				payment.setUsername(rs.getString(2));
				payment.setVin(rs.getString(3));
				payment.setAmount(rs.getDouble(4));
			}
		}
		catch(SQLException e) {
			trace("SQL exception in get payments by user name");
		}
		return payments;
	}
	
	public List<Payment> getAllPayments() {
		String sql = "select * from " + schema + ".payment_table";
		List<Payment> payments = new ArrayList<Payment>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Payment payment = new Payment();
				payment.setPayment_id(rs.getString(1));
				payment.setUsername(rs.getString(2));
				payment.setVin(rs.getString(3));
				payment.setAmount(rs.getDouble(4));
				payments.add(payment);
			}
		} catch (SQLException e) {
			trace("sql exception in get all payments");
		}
		return payments;
	}
}
