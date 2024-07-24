package com.RestroManagement.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE)
	private int id;
	
	@NotBlank(message="Enter name")
	private String name;
	
	@NotBlank(message="Enter name")
	private String username;
	
	@NotBlank(message="Enter name")
	@Size(min=3, max= 15, message="Length should be min 3 and max 15 ")
	private String password;
	
	@Transient
	private String confPassword;

	private String email;
	
	private Date birthdate;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Admin(int id, String name, String username, String password, String confPassword, String email,
			Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.confPassword = confPassword;
		this.email = email;
		this.birthdate = birthdate;
		
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}