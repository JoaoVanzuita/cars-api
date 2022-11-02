package com.joaovanzuita.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {

	@Autowired
	private CarDAO carDAO;

	public List<Car> getCars(){
		return carDAO.getAllCars();
	}

	public Car getCar(Long id) {
		return carDAO.getCarById(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean deleteCar(Long id) {
		return carDAO.deleteCar(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean saveCar(Car car) {
		carDAO.saveOrUpdate(car);

		return true;
	}
	
	public List<Car> findByName(String name){
		return carDAO.getCarByName(name);
	}
	
	public List<Car> findByType(String type){
		return carDAO.getCarsByType(type);
	}
}