package com.RestroManagement.Entity;
import jakarta.validation.constraints.NotBlank;

public class AdminLog {
	
	@NotBlank(message="Enter username")
	private String username;
	
	@NotBlank(message="Enter password")
	private String password;

	private boolean rememberMe;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminLog(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminLog [username=" + username + ", password=" + password + "]";
	}

	public AdminLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isRememberMe() {
		return rememberMe();
	}
	
	  private boolean rememberMe() {
		return false;
	}

	public void setRememberMe(boolean rememberMe) {
	        this.rememberMe = rememberMe;

}
}
