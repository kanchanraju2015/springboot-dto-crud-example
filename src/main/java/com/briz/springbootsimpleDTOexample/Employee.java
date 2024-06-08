package com.briz.springbootsimpleDTOexample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
String name;
int age;
// for mobile number specific
//@Pattern(regexp="[6-9]{1}[0-9]{9}",message="enter valid ph number")
String city;
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
