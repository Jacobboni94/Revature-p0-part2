package com.revature.util;

public class CarSystem implements menuUtil {

	private Input input = new Input();
	private Authorization authorization = new Authorization();
	private CarUtil carUtil = new CarUtil();
	private OfferUtil offerUtil = new OfferUtil();

	public CarSystem() {
		super();
	}

	public void startUp() {
		startMenu();
		String s = input.startMenuInput();
		if (s.equals("1")) {
			if (authorization.login().contentEquals("customer")) {
				while (true) {
					customerMenu();
					String custString = input.customerMenuInput();
					if (custString.equals("1")) {
						carUtil.viewMyCars(authorization.getCurrentUser());
					} else if (custString.equals("2")) {
						carUtil.viewCarsForSale();
					} else if (custString.equals("3")) {
						offerUtil.makeOffer(authorization.getCurrentUser());
					} else if (custString.equals("4")) {
						//viewRemainingPayments(); TODO
					} else if(custString.equals("5")){
						//makePayment(); TODO
					}
					else {
						systemExit();
					}
				}
			} else {
				while (true) {
					employeeMenu();
					String empString = input.employeeMenuInput();
					if (empString.equals("1")) {
						carUtil.addCarToLot();
					} else if (empString.equals("2")) {
						carUtil.removeCarFromLot();
					} else if (empString.equals("3")) {
						offerUtil.acceptOffer();
					} else if (empString.equals("4")) {
						offerUtil.rejectOffer();
					} else if (empString.equals("5")) {
						//viewAllPayments(); TODO
					} else {
						systemExit();
					}
				}
			}
		} else if (s.equals("2")) {
			authorization.register();

		} else {
			systemExit();
		}
	}

	public void systemExit() {
		input.closeInput();
		System.exit(0);
	}

	@Override
	public void startMenu() {
		System.out.println("1: Login");
		System.out.println("2: Regesiter");
		System.out.println("3: Exit");

	}

	@Override
	public void customerMenu() {
		System.out.println("1: View my cars");
		System.out.println("2: View cars for sale");
		System.out.println("3: Make offer for a car");
		System.out.println("4: View my remaining payments for a car");
		System.out.println("5: Make a payment on a car");
		System.out.println("6: Exit");
	}

	@Override
	public void employeeMenu() {
		System.out.println("1: Add a car to the lot");
		System.out.println("2: Remove a car from the lot");
		System.out.println("3: Accept an offer");
		System.out.println("4: Reject an offer");
		System.out.println("5: View all Payments");
		System.out.println("6: Exit");
	}
}
