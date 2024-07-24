package com.RestroManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RestroManagement.Entity.Employee;
import com.RestroManagement.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {
	
	private EmployeeService service;	
	
	@Autowired
	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
		
	@GetMapping("/newEmployee")
	public String NewEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "NewEmployee";		
	}
	
	@PostMapping("/employees")
	public String EmployeeAddedSuccesfully(@Valid @ModelAttribute ("employee") Employee employee, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/newEmployee";
		}
		service.SaveEmployee(employee);
		return "admindashboard";		
	}
	
	@GetMapping("employees/{id}")
	public String GetEmployeeById(@PathVariable int id,Model model) {
		model.addAttribute("employee", service.findEmployeeById(id));
		return "employee-details";
		
	}
	
	@GetMapping("/employees")
	public String GetAllEmployee(Model model) {
		model.addAttribute("employees", service.AllEmployees());
		return "employee-list";
		
	}
	
	@GetMapping("/employees/edit/{id}")
	public String ShowEditForm(@PathVariable int id,Model model) {
		model.addAttribute("employee", service.findEmployeeById(id));
		return "update-form";
		
	}
	
	
	@PostMapping("/employees/edit/{id}")
	public String UpdateEmployee(@PathVariable int id, Model model,Employee employee,BindingResult result,RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return"update-form";
		}
		employee.setId(id);
		service.updateEmployee(employee);
		redirectAttributes.addFlashAttribute("message"," Employee Updated Succesfully");
		return "redirect:/employees";
		
	}
	
	@GetMapping("employees/delete/{id}")
	public String DeleteEmployee(@PathVariable int  id,RedirectAttributes redirectAttributes) {
		service.DeleteEmployeeById(id);
		redirectAttributes.addFlashAttribute("message"," Employee Deleted Succesfully");
		return "redirect:/employees";
		
	}
}
