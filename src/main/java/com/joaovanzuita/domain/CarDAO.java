package com.joaovanzuita.domain;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@SuppressWarnings("unchecked")
public class CarDAO extends HibernateDAO<Car>{

	public CarDAO() {
		super(Car.class);
	}

	public Car getCarById(Long id){
		return super.get(id);
	}

	public List<Car> getCarByName(String name){
		Query query = getSession().createQuery("from Car where lower(name) like lower(?)");
		query.setString(0, "%" + name + "%");

		return query.list();
	}

	public List<Car> getCarsByType(String type){
		Query query = getSession().createQuery("from Car where type = ?");
		query.setString(0, type);
		List<Car> cars = query.list();

		return cars;
	}

	public List<Car> getAllCars(){
		Query query = getSession().createQuery("from Car");
		List<Car> cars = query.list();

		return cars;
	}

	public void saveCar(Car car){
		super.save(car);
	}

	public boolean deleteCar(Long id){
		Car car = get(id);
		delete(car);

		return true;
	}
}
