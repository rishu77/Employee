package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

//        import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	
	public List<Employee> getAllEmployees() {
	List<Employee> emp= employeeRepository.findAll();
		return emp;
	}

@Override

	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

@Override
public Employee getEmployeeById(long id) {
	
	java.util.Optional<Employee> optional =employeeRepository.findById(id);
	Employee employee =null;
	if(optional.isPresent()) {
		employee=optional.get();
		
	}
	else {
		throw new RuntimeException("Employee not found for id ::" + id);
		
	}
	return employee;
}

@Override
public void deleteEmployeeById(long id) {
	this.employeeRepository.deleteById(id);
}

@Override
public List<Employee> showAllEmlpoyee() {
	List<Employee> employees=new ArrayList<Employee>();
	for(Employee employee :employeeRepository.findAll()) {
		employees.add(employee);
	}
	return employees;
}

@Override
public List<Employee> findByKeyword(String keyword) {
	
	return employeeRepository.findByKeyword(keyword);
}

}
