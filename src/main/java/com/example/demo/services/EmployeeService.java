
package com.example.demo.services;

import java.util.List;




import com.example.demo.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	
	
	void deleteEmployeeById(long id);
List<Employee>showAllEmlpoyee();
List<Employee>findByKeyword(String keyword);

}

