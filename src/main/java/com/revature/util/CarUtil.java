package com.revature.util;

import java.util.List;

import com.revature.dao.CarDAO;
import com.revature.pojo.Car;

public class CarUtil {

	private Input input = new Input();
	private static CarDAO carDAO = new CarDAO();

	public boolean addCarToLot(){
		Car newCar = new Car();
		System.out.println("What is the car's vin?");
		newCar.setVin(input.getVin());
		System.out.println("What is the car's price?");
		newCar.setMarketPrice(input.getPrice());
		newCar.setOwner("dealership");
		carDAO.createCar(newCar);
		return true;
	}
	
	public boolean removeCarFromLot() {
		System.out.println("What is the car's vin?");
		String vin = input.getVin();
		carDAO.deleteCar(vin);
		return true;
	}
	
	public boolean viewMyCars(String username) {
		
		List<Car> cars = carDAO.getCarsByUsername(username);
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).toString());
		}
		return true;
	}
	
	public boolean viewCarsForSale() {
		List<Car> cars = carDAO.getCarsByUsername("dealership");
		for(int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).toString());
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
		CarUtil.carDAO = carDAO;
	}
	
	
}
