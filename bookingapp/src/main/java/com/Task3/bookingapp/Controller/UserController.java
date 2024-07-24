package com.Task3.bookingapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Task3.bookingapp.Entity.User1;
import com.Task3.bookingapp.Service.UserService;

@Controller
public class UserController {

	 @Autowired
	    private UserService userService;

	
	    @GetMapping("/register")
	    public String showRegistrationForm(Model model, @RequestParam(value = "success", required = false) String success) {
	        model.addAttribute("user", new User1());
	        if (success != null) {
	            model.addAttribute("message", "Registration successful!");
	        }
	        return "register";
	    }

	    @PostMapping("/register")
	    public String registerUser(@ModelAttribute("user") User1 user) {
	        System.out.println("User Details: " + user);
	        userService.saveUser(user);
	        return "redirect:/register?success=true";
	    }
}
