package com.RestroManagement.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.RestroManagement.Entity.Admin;

@Service
public interface AdminService {
	
	public Admin saveAdmin(Admin admin);
	
	public List<Admin> getListOfAdmin();
	
	 Admin findByEmail(String email);

	    void createPasswordResetTokenForUser(Admin admin, String token);

	    String validatePasswordResetToken(String token);

	    Admin getAdminByPasswordResetToken(String token);

	    void updatePassword(Admin admin, String newPassword);

}
