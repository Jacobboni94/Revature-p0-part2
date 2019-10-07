package com.revature.pojo;

public class Offer {

	
	private int offer_id;
	private double amount;
	private String username;
	private String vin;
	private String status;

	public Offer() {
		// TODO Auto-generated constructor stub
	}
	
	public Offer(int offer_id, double amount, String username, String vin, String status) {
		super();
		this.offer_id = offer_id;
		this.amount = amount;
		this.username = username;
		this.vin = vin;
		this.status = status;
	}

	public int getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Offer [offer_id=" + offer_id + ", amount=" + amount + ", username=" + username + ", vin=" + vin
				+ ", status=" + status + "]";
	}

}
