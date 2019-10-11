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

	public boolean makeOffer(String username) {
		Offer newOffer = new Offer();
		System.out.println("which car is the offer for?");
		String vin = input.getVin();
		Car car = carDAO.getCarByVin(vin);
		System.out.println("This car costs " + car.getMarketPrice() + ". How much will you offer?");
		newOffer.setAmount(input.getPrice());
		newOffer.setUsername(username);
		newOffer.setVin(vin);
		newOffer.setOffer_id("1");
		newOffer.setStatus("pending");
		offerDAO.createOffer(newOffer);
		return true;
	}

	public boolean rejectOffer() {
		System.out.println("Who's offers do you want to see?");
		String username = input.getUsername();
		List<Offer> offers = offerDAO.getOfferByUsername(username);
		for (int i = 0; i < offers.size(); i++) {
			System.out.println(i + 1 + ": " + offers.get(i).toString());
		}
		System.out.println("Which offer would you like to reject?");
		int offerNum = input.getInt(0, offers.size());
		offerDAO.updateOffer(offers.get(offerNum - 1), "rejected");
		return true;
	}

	public boolean acceptOffer() {
		System.out.println("Who's offers do you want to see?");
		String username = input.getUsername();
		List<Offer> offers = offerDAO.getOfferByUsername(username);
		for (int i = 0; i < offers.size(); i++) {
			System.out.println(i + 1 + ": " + offers.get(i).toString());
		}
		System.out.println("Which offer would you like to accept?");
		int offerNum = input.getInt(0, offers.size());
		Offer acceptedOffer = offers.get(offerNum -1);
		String vin = acceptedOffer.getVin();
		rejectOtherOffers(vin);
		Car boughtCar = carDAO.getCarByVin(vin);
		carDAO.updateOwner(boughtCar, username);
		carDAO.updatePrice(boughtCar, acceptedOffer.getAmount());
		return true;
	}
	
	public boolean rejectOtherOffers(String vin) {
		List<Offer> offers = offerDAO.getOfferByVin(vin);
		for(int i = 0; i < offers.size(); i++) {
			if(offers.get(i).getStatus().equals("pending")) {
				offerDAO.updateOffer(offers.get(i), "rejected");
			}
		}
		return true;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public CarDAO getCarDAO() {
		return carDAO;
	}

	public void setCarDAO(CarDAO carDAO) {
		OfferUtil.carDAO = carDAO;
	}

	public OfferDAO getOfferDAO() {
		return offerDAO;
	}

	public void setOfferDAO(OfferDAO offerDAO) {
		OfferUtil.offerDAO = offerDAO;
	}
	
	
}
