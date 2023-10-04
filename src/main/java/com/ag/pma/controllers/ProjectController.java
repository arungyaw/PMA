package com.ag.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ag.pma.dao.EmployeeRepository;
import com.ag.pma.dao.ProjectRepository;
import com.ag.pma.entities.Employee;
import com.ag.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired  //inject an auto created instance of this interface
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects",projects);
		return"projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	@PostMapping("/save")
	public String createProject(Project project,Model model) {
		//this should handle saving to the database.
		proRepo.save(project);
				
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/projects";
		
	}
	
}
