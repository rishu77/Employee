package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.EmployeeDetails;
import com.example.demo.repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	
	@Autowired
	private EmployeeDetailsRepository employeedetailsRepository;
	
	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		List<EmployeeDetails> empdetails= employeedetailsRepository.findAll();
		return empdetails;
	}

	@Override
	public void saveEmployeeDetails(EmployeeDetails employeedetails) {
		this.employeedetailsRepository.save(employeedetails);
		
	}

	@Override
	public EmployeeDetails getEmployeedetailsById(long id) {
		java.util.Optional<EmployeeDetails> optionald =employeedetailsRepository.findById(id);
		EmployeeDetails employeedetails =null;
		if(optionald.isPresent()) {
			employeedetails=optionald.get();
			
		}
		else {
			throw new RuntimeException("Employee not found for id ::" + id);
			
		}
		return employeedetails;
	}

	@Override
	public void deleteEmployeeDetailsById(long id) {
		this.employeedetailsRepository.deleteById(id);
	}

}
