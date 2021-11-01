package com.example.demo.services;

import java.util.List;



import com.example.demo.model.EmployeeDetails;

public interface EmployeeDetailsService {

	
	List<EmployeeDetails> getAllEmployeeDetails();
	
	void saveEmployeeDetails(EmployeeDetails employeedetails); 
	EmployeeDetails getEmployeedetailsById(long id);
	


	void deleteEmployeeDetailsById(long id);
}

