
package com.briz.springbootsimpleDTOexample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return "This is DTO TEST";
}
@RequestMapping("/save")// data is passed as DTO not by entity 
public String save(@RequestBody EmployeeDTO employeedto)// DTO to Entity conversion 
{
	Employee e=new Employee();
	e.setName(employeedto.getName());
	e.setCity(employeedto.getCity());
	e.setAge(employeedto.getAge());
	//e.setId(employeedto.getId()); id is not passed into dto 
    erepo.save(e);
	return "data is saved";	
}

@RequestMapping("/all")// THIS IS FOR ENTITY TO DTO CONVERSION NOTE IMPOTANT 
public List<EmployeeDTO> alldata()
{
return erepo.findAll().stream().map(employee->
{
EmployeeDTO employeedto=new EmployeeDTO();
employeedto.setAge(employee.getAge());
employeedto.setName(employee.getName());
employeedto.setCity(employee.getCity());
employeedto.setId(employee.getId());
return employeedto;// employeedto is stream 
}).collect(Collectors.toList()); // changing again to the list check the return type 
}
@RequestMapping("/{id}")
public EmployeeDTO byid(@PathVariable int id)
{
Employee employee=erepo.findById(id).get();
EmployeeDTO employeedto=new EmployeeDTO();
BeanUtils.copyProperties(employee, employeedto);// there must be all the fields in entity as well as dto 	
return employeedto;
}
@RequestMapping("/by/{city}")
public List<EmployeeDTO> bycity(@PathVariable String city)
{
return erepo.findByCity(city).stream().map(employee->
{
EmployeeDTO employeedto=new EmployeeDTO();
employeedto.setAge(employee.getAge());
employeedto.setName(employee.getName());
employeedto.setCity(employee.getCity());
employeedto.setId(employee.getId());
return employeedto;// returning as stream
}).collect(Collectors.toList());// changing to the list 
}
@RequestMapping("/update/{id}")
public EmployeeDTO upd(@PathVariable int id,@RequestBody EmployeeDTO employeedto)
{
Employee emp=erepo.findById(id).get();
emp.setAge(employeedto.getAge());
emp.setName(employeedto.getName());
emp.setCity(employeedto.getCity());
//BeanUtils.copyProperties(emp,employeedto); not working this 
erepo.save(emp);
return employeedto;
}
}

