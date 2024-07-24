package com.RestroManagement.Controller;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.multipart.MultipartFile;

import com.RestroManagement.Entity.Admin;
import com.RestroManagement.service.AdminService;

import jakarta.transaction.Transactional;
	import jakarta.validation.Valid;

	@Controller
	@Transactional
	public class HotelAdminController {
		
		@Autowired
		private AdminService admService;
		
		@GetMapping("/")
		public String getRegister(Model model) {
			model.addAttribute("admin", new Admin());
			return "adminregister";
			
		}
		
		@PostMapping("/regstatus")
		public String getStatus(@Valid @ModelAttribute("admin") Admin admin, BindingResult bindResult, Model model) {
			
			if(bindResult.hasErrors()) {
		        return "adminregister";
		    }    
			
			if(!admin.getConfPassword().equals(admin.getPassword())) {
				model.addAttribute("error", "Password and confirm password should be same");
				return "adminregister";
			}
			
			
			admService.saveAdmin(admin);
		    return "redirect:/loginForm";
		}


	}
