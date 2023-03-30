package com.avdhoot.jerseyrest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienRepo {
	Connection connection = null;
	
	public AlienRepo() {
		String url = "jdbc:mysql://localhost:3306/jerseyapi";
		String username = "root";
		String password = "28022002";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<>();
		String sqlString = "select * from Alien";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlString);
			while(resultSet.next()) {
				Alien alien = new Alien();
				alien.setId(resultSet.getInt(1));
				alien.setName(resultSet.getString(2));
				alien.setPoints(resultSet.getInt(3));
				aliens.add(alien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aliens;
	}

	public Alien getAlien(long id) {
		String sqlString = "select * from Alien where id="+id;
		Alien alien = new Alien();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlString);
			if(resultSet.next()) {
				alien.setId(resultSet.getInt(1));
				alien.setName(resultSet.getString(2));
				alien.setPoints(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return alien;
	}

	
	public void createAlien(Alien a1) {
		String sqlString = "insert into Alien values (?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			
			statement.setInt(1, a1.getId());
			statement.setString(2, a1.getName());
			statement.setInt(3, a1.getPoints());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateAlien(Alien a1) {
		String sqlString = "update alien set name=?, points=? where id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			
			statement.setInt(3, a1.getId());
			statement.setString(1, a1.getName());
			statement.setInt(2, a1.getPoints());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		String sqlString = "delete from alien where id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
