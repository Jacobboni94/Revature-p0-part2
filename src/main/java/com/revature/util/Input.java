package com.revature.util;

import java.util.Scanner;

import com.revature.dao.UserDAO;

public class Input {

	private Scanner sc = new Scanner(System.in);
	private static UserDAO userDAO = new UserDAO();

	public Input() {
		// TODO Auto-generated constructor stub
	}

	public String startMenuInput() {
		String ret = sc.nextLine();
		while (!(ret.equals("1") || ret.equals("2") || ret.equals("3"))) {
			System.out.println("Please enter 1 through 3");
			ret = sc.nextLine();
		}
		return ret;
	}

	public String customerMenuInput() {
		String ret = sc.nextLine();
		while (!(ret.equals("1") || ret.equals("2") || ret.equals("3") || ret.equals("4") || ret.equals("5"))) {
			System.out.println("please enter 1 through 5");
			ret = sc.nextLine();
		}
		return ret;
	}

	public String employeeMenuInput() {
		String ret = sc.nextLine();
		while (!(ret.equals("1") || ret.equals("2") || ret.equals("3") || ret.equals("4") || ret.equals("5")
				|| ret.contentEquals("6"))) {
			System.out.println("please enter 1 through 6");
			ret = sc.nextLine();
		}
		return ret;
	}

	public String getNewUsername() {
		String ret = sc.nextLine();
		while ((ret.length() < 3 || ret.length() > 16) && userDAO.usernameTaken(ret)) {
			System.out.println("Username must be between 3 and 16 characters");
			ret = sc.nextLine();
		}
		return ret;
	}

	public String getUsername() {
		String ret = sc.nextLine();
		while (true) {
			if (!userDAO.usernameTaken(ret)) {
				return ret;
			} else {
				System.out.println("Username not found");
				ret = sc.nextLine();
			}
		}
	}

	public String getPassword() {
		String ret = sc.nextLine();
		while (ret.length() < 8 || ret.length() > 16) {
			System.out.println("Password must be between 8 and 16 characters");
			ret = sc.nextLine();
		}
		return ret;
	}

	public String getVin() { //TODO check if vin is in database
		String ret = sc.nextLine();
		while (ret.length() != 17) {
			System.out.println("That's not a valid vin");
			ret = sc.nextLine();
		}
		return ret;
	}

	public double getPrice() {
		String ret = sc.nextLine();
		double ret_double;
		while (true) {
			try {
				ret_double = Double.parseDouble(ret);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
				ret = sc.nextLine();
			}
		}
		return ret_double;
	}

	public int getInt(int n1, int n2) {
		String ret = sc.nextLine();
		int ret_int;
		while(true) {
			try {
				ret_int = Integer.parseInt(ret);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter a number between " + n1 + " and " + n2 + ".");
			}
		}
		return ret_int;
	}
	
	public void closeInput() {
		sc.close();
	}
}
