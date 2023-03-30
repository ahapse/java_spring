package com.avdhoot.spring.jdbc1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avdhoot.spring.jdbc1.entities.Student;

public class RowMapperImpl implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt(1));
		student.setNameString(rs.getString(2));
		student.setCityString(rs.getString(3));
		
		return student;
	}

}
