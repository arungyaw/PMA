package com.ag.pma.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ag.pma.dao.EmployeeRepository;
import com.ag.pma.entities.Employee;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	

		@Autowired  //inject an auto created instance of this interface
		EmployeeRepository empRepo;
		
		@GetMapping
		public String displayEmployees(Model model) {
			List<Employee> employees = empRepo.findAll();
			model.addAttribute("employees",employees);
			return"employees/list-employees";
		}
		
		@GetMapping("/new")
		public String displayEmployeeForm(Model model) {
			Employee anEmployee = new Employee();
			model.addAttribute("employee", anEmployee);
			return "employees/new-employee";
		}
		@PostMapping("/save")
		public String createProject(Employee employee,Model model) {
			//this should handle saving to the database.
			empRepo.save(employee);
			
			//use a redirect to prevent duplicate submissions
			return "redirect:/employees/new";
			
		
	}


}
