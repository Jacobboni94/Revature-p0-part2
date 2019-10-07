package com.revature.util;

import java.util.List;

import com.revature.dao.PaymentDAO;
import com.revature.pojo.Car;
import com.revature.pojo.Payment;

public class PaymentUtil {
	
	private static PaymentDAO paymentDAO = new PaymentDAO();
	
	Input input = new Input();

	public void makePayment() {
		System.out.println("which car would you like to pay for?");
		String vin = input.getVin();
		List<Payment> payments = paymentDAO.getPaymentsByVin(vin);
		
		Payment newPayment = new Payment();
		
	}

	public double remainingPayments(Car c, List<Payment> payments) {
		double ret = 0.0;
		
		return ret;
	}
	
}
