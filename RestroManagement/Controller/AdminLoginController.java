

package com.RestroManagement.Controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.RestroManagement.Entity.Admin;
import com.RestroManagement.Entity.AdminLog;
import com.RestroManagement.service.AdminService;

import jakarta.validation.Valid;

@Controller
public class AdminLoginController {
	
	@Autowired
	private AdminService admService;
	
	
	@GetMapping("/loginForm")
	public String getLogin(Model model) {
		model.addAttribute("adminlog", new AdminLog());
		return "adminlogin";
		
	}
	
	@PostMapping("/dashboard")
	public String getDashboard(@Valid @ModelAttribute("adminlog") AdminLog adminLog,BindingResult bindingResult, Model model) {
	if(bindingResult.hasErrors()) {
		
		return "adminlogin";
	}
	List<Admin> listOfAdmin = admService.getListOfAdmin();
		String username = adminLog.getUsername();
		String password = adminLog.getPassword();
        boolean rememberMe = adminLog.isRememberMe();

		boolean found= false;
		int id= 0;
		for(Admin adm : listOfAdmin) {
			if(adm.getUsername().equals(username) && adm.getPassword().equals(password)) {
				id = adm.getId();
				found= true;
				break;

			}
		}
//			if(found== true) {
//				
//				return "admindashboard1";
//		
		 if (found) {
	            if (rememberMe) {
	            }
	            return "admindashboard1";
		
	}else {
		model.addAttribute("error", "Username or password is not correct");
		return "adminlogin";
	}		
		
	}

	  @GetMapping("/forgotPassword")
	    public String showForgotPasswordForm(Model model) {
	        return "forgotPassword";
	    }

	    @PostMapping("/forgotPassword")
	    public String processForgotPassword(String email, Model model) {
	        Admin admin = admService.findByEmail(email);
	        if (admin == null) {
	            model.addAttribute("message", "No account found with that email address.");
	            return "forgotPassword";
	        }

	        // Generate reset token
	        String resetToken = UUID.randomUUID().toString();
	        admService.createPasswordResetTokenForUser(admin, resetToken);

	        // Send email with reset link (implementation not shown)
	        // sendResetEmail(admin.getEmail(), resetToken);

	        model.addAttribute("message", "A password reset link has been sent to your email.");
	        return "forgotPassword";
	    }

	    @GetMapping("/resetPassword")
	    public String showResetPasswordForm(String token, Model model) {
	        String result = admService.validatePasswordResetToken(token);
	        if (result != null) {
	            model.addAttribute("message", result);
	            return "redirect:/loginForm";
	        }

	        model.addAttribute("token", token);
	        return "resetPassword";
	    }

	    @PostMapping("/resetPassword")
	    public String processResetPassword(String token, String newPassword, Model model) {
	        String result = admService.validatePasswordResetToken(token);
	        if (result != null) {
	            model.addAttribute("message", result);
	            return "redirect:/loginForm";
	        }

	        Admin admin = admService.getAdminByPasswordResetToken(token);
	        if (admin == null) {
	            model.addAttribute("message", "Invalid token.");
	            return "resetPassword";
	        }

	        admService.updatePassword(admin, newPassword);
	        model.addAttribute("message", "Your password has been successfully reset.");
	        return "redirect:/loginForm";
	    }
	}


