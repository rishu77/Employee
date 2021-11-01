package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.EmployeeDetails;
import com.example.demo.services.EmployeeDetailsService;

@Controller
public class EmployeeDetailsController {
	
@Autowired
	
	private EmployeeDetailsService employeedetailsservice;
	
	@GetMapping("/employeedetails")
	public String viewHomePage1(Model model1) {
		model1.addAttribute("listEmployeeDetails",employeedetailsservice.getAllEmployeeDetails());
		return "index1";
	}
	

@GetMapping("/showNewEmployeeDetailsForm")
	public String showNewEmployeeDetailsForm(Model model1){
	//create model attribute to bind form data
		EmployeeDetails employeedetails =new EmployeeDetails();
		model1.addAttribute("employeedetails",employeedetails);
		return "new_employeedetails";
	}
	
@PostMapping("/saveEmployeeDetails")
public String saveEmployeeDetails(@ModelAttribute("employeedetails") EmployeeDetails employeedetails) {
	//save employee to database
	employeedetailsservice.saveEmployeeDetails(employeedetails);
	return "redirect:/employeedetails"; 
	
}
	
}
