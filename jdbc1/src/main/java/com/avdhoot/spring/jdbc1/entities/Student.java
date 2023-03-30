package com.avdhoot.spring.jdbc1.entities;

public class Student {
	private int id;
	private String nameString;
	private String cityString;
	public Student(int id, String nameString, String cityString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.cityString = cityString;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", nameString=" + nameString + ", cityString=" + cityString + "]";
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getCityString() {
		return cityString;
	}
	public void setCityString(String cityString) {
		this.cityString = cityString;
	}
	
	
}
