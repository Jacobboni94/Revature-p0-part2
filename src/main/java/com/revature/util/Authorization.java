package com.revature.util;

import com.revature.dao.UserDAO;
import com.revature.pojo.User;

import static com.revature.util.LoggerUtil.trace;

public class Authorization {

	private static UserDAO userDAO = new UserDAO();
	private static Input input = new Input();
	private String currentUser;

	public String login() {
		System.out.println("Please enter your username");
		String username = input.getUsername();
		User user = userDAO.getUserByUsername(username);
		while (true) {
			System.out.println("Please enter your password");
			String inputPassword = input.getPassword();
			if (inputPassword.equals(user.getPassword())) {
				if (user.getType().equals("customer")) {
					trace("customer log in successfull");
					setCurrentUser(user.getUsername());
					return "customer";
				} else {
					trace("employee login successfull");
					setCurrentUser(user.getUsername());
					return "employee";
				}
			} else {
				System.out.println("Wrong password");
			}
		}
	}

	public boolean register() {
		User newUser = new User();
		System.out.println("Please choose a username");
		newUser.setUsername(input.getNewUsername());
		System.out.println("Please choose a password");
		newUser.setPassword(input.getPassword());
		newUser.setType("customer");
		userDAO.createUser(newUser);
		return true;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	

}
