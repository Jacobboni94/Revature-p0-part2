package com.revature.dao;

import static com.revature.util.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.jdbc.util.ConnectionFactory;
import com.revature.pojo.Offer;

public class OfferDAO {

	private static Connection conn = ConnectionFactory.getConnection();

	private String schema = "project0_test";

	public Offer getOfferByID(String offerID) {

		String sql = "select * from " + schema + ".offer_table where offer_id = ?";

		PreparedStatement stmt;

		Offer offer = new Offer();

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, offerID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				offer.setOffer_id(rs.getInt(1));
				offer.setVin(rs.getString(2));
				offer.setUsername(rs.getString(3));
				offer.setAmount(rs.getDouble(4));
				offer.setStatus(rs.getString(5));
			}

		} catch (SQLException e) {
			trace("username not found");
			e.printStackTrace();
		}

		return offer;

	}

	public void createOffer(Offer o) {

		String sql = "insert into " + schema + ".offer_table (vin, username, amount, status) values (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, o.getVin());
			stmt.setString(2, o.getUsername());
			stmt.setDouble(3, o.getAmount());
			stmt.setString(4, o.getStatus());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOffer(Offer o, String newStatus) {

		String sql = "update " + schema + ".offer_table set status = ? where offer_id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newStatus);
			stmt.setInt(2, o.getOffer_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteOffer(String offer_id) {
		String sql = "delete from " + schema + ".offer_table where offer_id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, offer_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
