package com.Task3.bookingapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User1 {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	    private String fullName;
	    private String email;
	    private String password;
	    private String phoneNumber;
	    private String address;
	    private String idProof;
	    private String idProofType;
		
	    
	    public User1(Long id, String fullName, String email, String password, String phoneNumber, String address,
				String idProof, String idProofType) {
			super();
			this.id = id;
			this.fullName = fullName;
			this.email = email;
			this.password = password;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.idProof = idProof;
			this.idProofType = idProofType;
		}
            
	    public User1() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getIdProof() {
			return idProof;
		}

		public void setIdProof(String idProof) {
			this.idProof = idProof;
		}

		public String getIdProofType() {
			return idProofType;
		}

		public void setIdProofType(String idProofType) {
			this.idProofType = idProofType;
		}

		@Override
		public String toString() {
			return "User1 [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
					+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", idProof=" + idProof
					+ ", idProofType=" + idProofType + "]";
		}

	
	    


		
}
