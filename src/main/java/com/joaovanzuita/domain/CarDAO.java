package com.joaovanzuita.domain;

import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private static final String sqlCreate = "INSERT INTO cars(name,description,url_image,url_video,latitude,longitude,type) VALUES(?,?,?,?,?,?,?);";
    private static final String sqlDelete = "DELETE FROM cars WHERE id_car = ?;";
    private static final String sqlUpdate = "UPDATE cars set name=?, description=?, url_image=?, url_video=?, latitude=?, longitude=?, type=? WHERE id_car=?";
    private static final String sqlGetByName = "SELECT * FROM cars WHERE name LIKE ? ;";
    private static final String sqlGetByType = "SELECT * FROM cars WHERE type LIKE ? ;";
    private static final String sqlGetById = "SELECT * FROM cars WHERE id_car = ?;";
    private static final String sqlGetAll = "SELECT * FROM cars;";

	public CarDAO() {
	}

	public Car getCarById(Long id) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sqlGetById);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				Car car = createCar(result);
				result.close();
				return car;
			}
		}finally{
			if(statement != null)
				statement.close();
			
			if(connection != null)
				connection.close();
		}
		return null;
	}
		
	public List<Car> getCarsByName(String name) throws SQLException{
		
		List<Car> cars = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sqlGetByName);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				cars.add(createCar(result));
			}
			
			result.close();
			
		}finally {
			if(statement != null)
				statement.close();
			
			if(connection != null)
				connection.close();
		}
				
		return cars;
	}
	
	public List<Car> getCarsByType(String type) throws SQLException{
		
		List<Car> cars = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sqlGetByType);
			statement.setString(1, type);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				cars.add(createCar(result));
			}
			
			result.close();
			
		}finally {
			if(statement != null)
				statement.close();
			
			if(connection != null)
				connection.close();
		}
				
		return cars;
	}
	
	public List<Car> getAllCars() throws SQLException{
		
		List<Car> cars = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sqlGetAll);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				cars.add(createCar(result));
			}
			
			result.close();
			
		}finally {
			if(statement != null)
				statement.close();
			
			if(connection != null)
				connection.close();
		}
				
		return cars;
	}
	
	public void saveCar(Car car) throws SQLException{
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			connection = ConnectionFactory.getConnection();
			
			if(car.getIdCar() == null) {
				statement = connection.prepareStatement(sqlCreate, Statement.RETURN_GENERATED_KEYS);
			}else {
				statement = connection.prepareStatement(sqlUpdate);
			}
			
			statement.setString(1, car.getName());
			statement.setString(2, car.getDescription());
			statement.setString(3, car.getUrlImage());
			statement.setString(4, car.getUrlVideo());
			statement.setString(5, car.getLatitude());
			statement.setString(6, car.getLongitude());
			statement.setString(7, car.getType());
			
			if(car.getIdCar() != null) {
				statement.setLong(8, car.getIdCar());
			}
			
			int count = statement.executeUpdate();
			if(count == 0) {
				throw new SQLException("Error inserting car");
			}
			
			if(car.getIdCar() == null) {
				car.setIdCar(getGeneratedId(statement));
			}	
		}finally {
			if(statement != null)
				statement.close();
			
			if(connection != null)
				connection.close();
		}
	}
	
	public Long getGeneratedId(PreparedStatement statement) throws SQLException{
		
		ResultSet result = statement.getGeneratedKeys();
		
		if(result.next()) {
			return result.getLong(1);
		}
		
		return 0L;
	}
	
	public boolean deleteCar(Long id) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sqlDelete);
			statement.setLong(1, id);
			
			int count = statement.executeUpdate();
			return count > 0;
			
		}finally {
			if(statement != null)
				statement.close();
			
			if(connection != null)
				connection.close();
		}
		
	}
	
	private Car createCar(ResultSet result) throws SQLException {
		Car car = new Car();
		
		car.setIdCar(result.getLong("id_car"));
		car.setName(result.getString("name"));
		car.setDescription(result.getString("description"));
		car.setUrlImage(result.getString("url_image"));
		car.setUrlVideo(result.getString("url_video"));
		car.setLatitude(result.getString("latitude"));
		car.setLongitude(result.getString("longitude"));
		car.setType(result.getString("type"));
		
		return car;
	}
	
}
