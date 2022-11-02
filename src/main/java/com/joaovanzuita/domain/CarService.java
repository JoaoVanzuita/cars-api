package com.joaovanzuita.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {
	
	private static CarService instance;

	@Autowired
	private CarDAO carDAO;
	
	public static CarService getInstace() {	
		if(instance == null) {
			instance = new CarService();
		}
		return instance;
	}
	
	private CarService() {
	}

	public List<Car> getCars(){
				
		try {
			
			List<Car> cars = carDAO.getAllCars();
			return cars;
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return new ArrayList<Car>();
		}		
	}

	public Car getCar(Long id) {
		try {
			
			return carDAO.getCarById(id);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteCar(Long id) {
		
		try {
			
			return carDAO.deleteCar(id);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean saveCar(Car car) {
		try {
			
			carDAO.saveCar(car);
			return true;
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Car> findByName(String name){
	
		try {
			
			List<Car> cars = carDAO.getCarsByName(name);
			return cars;
			
		}catch (Exception e) {
			
			return null;	
		}
	}
	
	public List<Car> findByType(String type){
		
		try {
			
			List<Car> cars = carDAO.getCarsByType(type);
			return cars;
			
		}catch (Exception e) {
			
			return null;		
		}
	}
}




