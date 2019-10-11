package com.revature.dao;

import static com.revature.util.LoggerUtil.trace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				offer.setOffer_id(rs.getString(1));
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

	public List<Offer> getOfferByUsername(String username) {
		String sql = "select * from " + schema + ".offer_table where username = ?";
		PreparedStatement stmt;
		List<Offer> offers = new ArrayList<Offer>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Offer offer = new Offer();
				offer.setOffer_id(rs.getString(1));
				offer.setVin(rs.getString(2));
				offer.setUsername(rs.getString(3));
				offer.setAmount(rs.getDouble(4));
				offer.setStatus(rs.getString(5));
				offers.add(offer);
			}
		} catch (SQLException e) {
			trace("sql exception in get offers by username");
		}
		return offers;
	}
	
	public List<Offer> getOfferByVin(String vin){
		String sql = "select * from " + schema + ".offer_table where vin = ?";
		PreparedStatement stmt;
		List<Offer> offers = new ArrayList<Offer>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vin);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Offer offer = new Offer();
				offer.setOffer_id(rs.getString(1));
				offer.setVin(rs.getString(2));
				offer.setUsername(rs.getString(3));
				offer.setAmount(rs.getDouble(4));
				offer.setStatus(rs.getString(5));
				offers.add(offer);
			}
		} catch (SQLException e) {
			trace("sql exception in get offers by vin");
		}
		return offers;
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
			stmt.setInt(2, Integer.parseInt(o.getOffer_id()));
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
