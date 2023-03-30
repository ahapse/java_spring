package com.avdhoot.spring.jdbc1.dao;

import com.avdhoot.spring.jdbc1.entities.Student;

public interface StudentDao {
	public int create(Student student);
	public Student getStudent(int studentId);
}
