package com.RestroManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping("/godashboard")
	public String getDashBoard() {
		return "admindashboard1";
		
	}
	
	@GetMapping("/go")
	public String getDashBoardMain() {
		return "admindashboard";
		
	}
	

}