package com.avdhoot.spring.jdbc1.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.avdhoot.spring.jdbc1.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemp;
	
	public int create(Student student) {
		String queryString = "insert into student(id, name, city) values(?,?,?)";
		int r = this.jdbcTemp.update(queryString, student.getId(), student.getNameString(), student.getCityString());
		return r;
	}
	
	public JdbcTemplate geTemplate() {
		return jdbcTemp;
	}
	
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}

	public Student getStudent(int studentId) {
		String queryString = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemp.queryForObject(queryString, rowMapper, studentId);
		return student;
	}

}
