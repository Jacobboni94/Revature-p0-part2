package com.revature.pojo;

public class Payment {
	
	private String payment_id;
	private String username;
	private String vin;
	private double amount;

	public Payment() {
		super();
	}

	public Payment(String payment_id, String username, String vin, double amount) {
		super();
		this.payment_id = payment_id;
		this.username = username;
		this.vin = vin;
		this.amount = amount;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", username=" + username + ", vin=" + vin + ", amount=" + amount
				+ "]";
	}
 
}
