package com.revature.util;

import java.util.List;

import com.revature.dao.CarDAO;
import com.revature.dao.PaymentDAO;
import com.revature.pojo.Car;
import com.revature.pojo.Payment;

public class PaymentUtil {

	private static PaymentDAO paymentDAO = new PaymentDAO();
	private static CarDAO carDAO = new CarDAO();

	Input input = new Input();

	public void makePayment(String username) {
		System.out.println("which car would you like to pay for?");
		String vin = input.getVin();
		List<Payment> payments = paymentDAO.getPaymentsByVin(vin);
		double sum = 0;
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

	public double remainingPayments(Car c, List<Payment> payments) {
		double ret = 0.0;

		return ret;
	}

}
