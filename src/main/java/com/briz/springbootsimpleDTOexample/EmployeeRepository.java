package com.briz.springbootsimpleDTOexample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer>
{
List<Employee> findByCity(String city);
}
