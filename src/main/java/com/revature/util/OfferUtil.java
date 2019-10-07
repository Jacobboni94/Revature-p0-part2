package com.revature.util;

import com.revature.dao.CarDAO;
import com.revature.dao.OfferDAO;
import com.revature.pojo.Car;
import com.revature.pojo.Offer;

public class OfferUtil {
	
	private Input input = new Input();
	private static CarDAO carDAO = new CarDAO();
	private static OfferDAO offerDAO = new OfferDAO();

	public OfferUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public void makeOffer(String username) {
		Offer newOffer = new Offer();
		System.out.println("which car is the offer for?");
		String vin = input.getVin();
		//TODO check if vin is in the database
		Car car = carDAO.getCarByVin(vin);
		System.out.println("This car costs " + car.getMarketPrice() + ". How much will you offer?");
		newOffer.setAmount(input.getPrice());
		newOffer.setUsername(username);
		newOffer.setVin(vin);
		newOffer.setOffer_id(1); //TODO make sql thing where the id is always incremented by one
		newOffer.setStatus("pending");
		offerDAO.createOffer(newOffer);
		}

}
