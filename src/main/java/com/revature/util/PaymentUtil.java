package com.revature.util;

import java.util.List;

import com.revature.dao.CarDAO;
import com.revature.dao.PaymentDAO;
import com.revature.pojo.Car;
import com.revature.pojo.Payment;

public class PaymentUtil {

	private static PaymentDAO paymentDAO = new PaymentDAO();
	private static CarDAO carDAO = new CarDAO();
	private Input input = new Input();

	public void makePayment(String username) {
		System.out.println("which car would you like to pay for?");
		String vin = input.getVin();
		List<Payment> payments = paymentDAO.getPaymentsByVin(vin);
		double sum = 0.0;
		Car car = carDAO.getCarByVin(vin);
		for (int i = 0; i < payments.size(); i++) {
			sum += payments.get(i).getAmount();
		}
		double remaining = car.getMarketPrice() - sum;
		System.out.println("You have to pay off this much for this car: " + remaining);
		System.out.println("How much would you like to pay");
		double payment = input.getPayment(remaining);
		Payment newPayment = new Payment("1", username, vin, payment);
		paymentDAO.createPayment(newPayment);
	}

	public void viewRemainingPayments(String username) {
		System.out.println("For which car do you want ot view the remaining payments?");
		String vin = input.getVin();
		List<Payment> payments = paymentDAO.getPaymentsByVin(vin);
		double sum = 0.0;
		for (int i = 0; i < payments.size(); i++) {
			sum += payments.get(i).getAmount();
		}
		double total = carDAO.getCarByVin(vin).getMarketPrice();
		System.out.println("You owe $" + (total - sum) + " on this car.");
		System.out.println("You're monthly payment is $" + (total - sum) / 60);
	}

	public void viewAllPayments() {
		List<Payment> payments = paymentDAO.getAllPayments();
		for (int i = 0; i < payments.size(); i++) {
			System.out.println(payments.get(i).toString());
		}
	}
}
