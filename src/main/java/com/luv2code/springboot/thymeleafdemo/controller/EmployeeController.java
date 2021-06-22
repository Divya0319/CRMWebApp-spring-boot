package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		// create employees
		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@gmail.com");
		Employee emp2 = new Employee(1, "Marcus", "Brutus", "mark@gmail.com");
		Employee emp3 = new Employee(1, "Franklin", "Clinton", "frank@gmail.com");
		Employee emp4 = new Employee(1, "Trevor", "Philips", "trevorphilipsindustries@gmail.com");
		
		// create the list
		theEmployees = new ArrayList<>();
		
		// add to the list
		
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		theEmployees.add(emp4);
	}
	
	// add mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
