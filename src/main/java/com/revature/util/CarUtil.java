package com.revature.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.CarDAO;
import com.revature.pojo.Car;

public class CarUtil {

	private Input input = new Input();
	private static CarDAO carDAO = new CarDAO();

	public void addCarToLot(){
		Car newCar = new Car();
		System.out.println("What is the car's vin?");
		newCar.setVin(input.getVin());
		System.out.println("What is the car's price?");
		newCar.setMarketPrice(input.getPrice());
		newCar.setOwner("dealership");
		carDAO.createCar(newCar);
	}
	
	public void removeCarFromLot() {
		System.out.println("What is the car's vin?");
		String vin = input.getVin();
		carDAO.deleteCar(vin);
	}
	
	public void viewMyCars(String username) {
		
		ResultSet rs = carDAO.getCarsByUsername(username);
		try {
			while(rs.next()) {
				Car car = new Car();
				car.setVin(rs.getString(1));
				car.setOwner(rs.getString(2));
				car.setMarketPrice(rs.getDouble(3));
				System.out.println(car);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewCarsForSale() {
		ResultSet rs = carDAO.getCarsByUsername("dealership");
		try {
			while(rs.next()) {
				Car car = new Car();
				car.setVin(rs.getString(1));
				car.setOwner(rs.getString(2));
				car.setMarketPrice(rs.getDouble(3));
				System.out.println(car);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
