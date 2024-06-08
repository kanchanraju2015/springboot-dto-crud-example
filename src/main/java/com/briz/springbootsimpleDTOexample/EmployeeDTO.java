package com.briz.springbootsimpleDTOexample;

import jakarta.validation.constraints.NotNull;

public class EmployeeDTO
{
	int id;
	@NotNull(message="Name is Empty")
	String name;
	int age;
	String city;
	
	// for mobile number specific
	//@Pattern(regexp="[6-9]{1}[0-9]{9}",message="enter valid ph number")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
