package com.revature.pojo;

public class Car {
	
	private String vin;
	
	private String owner;
	
	private double marketPrice;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String vin, String owner, double marketPrice) {
		super();
		this.vin = vin;
		this.owner = owner;
		this.marketPrice = marketPrice;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", owner=" + owner + ", marketPrice=" + marketPrice + "]";
	}
	
	

}
