package com.revature.util;

import java.util.List;

import com.revature.dao.CarDAO;
import com.revature.dao.OfferDAO;
import com.revature.pojo.Car;
import com.revature.pojo.Offer;

public class OfferUtil {

	private Input input = new Input();
	private static CarDAO carDAO = new CarDAO();
	private static OfferDAO offerDAO = new OfferDAO();

	public void makeOffer(String username) {
		Offer newOffer = new Offer();
		System.out.println("which car is the offer for?");
		String vin = input.getVin();
		// TODO check if vin is in the database
		Car car = carDAO.getCarByVin(vin);
		System.out.println("This car costs " + car.getMarketPrice() + ". How much will you offer?");
		newOffer.setAmount(input.getPrice());
		newOffer.setUsername(username);
		newOffer.setVin(vin);
		newOffer.setOffer_id("1");
		newOffer.setStatus("pending");
		offerDAO.createOffer(newOffer);
	}

	public void rejectOffer() {
		System.out.println("Who's offers do you want to see?");
		String username = input.getUsername();
		List<Offer> offers = offerDAO.getOfferByUsername(username);
		for (int i = 0; i < offers.size(); i++) {
			System.out.println(i + 1 + ": " + offers.get(i).toString());
		}
		System.out.println("Which offer would you like to reject?");
		int offerNum = input.getInt(0, offers.size());
		offerDAO.updateOffer(offers.get(offerNum - 1), "rejected");
	}

	public void acceptOffer() {
		System.out.println("Who's offers do you want to see?");
		String username = input.getUsername();
		List<Offer> offers = offerDAO.getOfferByUsername(username);
		for (int i = 0; i < offers.size(); i++) {
			System.out.println(i + 1 + ": " + offers.get(i).toString());
		}
		System.out.println("Which offer would you like to accept?");
		int offerNum = input.getInt(0, offers.size());
		Offer acceptedOffer = offers.get(offerNum -1);
		for (int i = 0; i < offers.size(); i++) {
			if ( acceptedOffer.getVin().equals(offers.get(i).getVin()) ) {
				if (i == offerNum - 1) {
					offerDAO.updateOffer(offers.get(i), "accepted");
				} else {
					offerDAO.updateOffer(offers.get(i), "rejected");
				}
			}
		}
		String vin = acceptedOffer.getVin();
		Car boughtCar = carDAO.getCarByVin(vin);
		carDAO.updateOwner(boughtCar, username);
		carDAO.updatePrice(boughtCar, acceptedOffer.getAmount());
	}
}
