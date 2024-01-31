package com.employee.employee.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;
@Document(collection = "users")
public class Employee {

	    @Id
	    private String id;
	    private String employeeName;
	    private String phoneNumber;
	    private String email;
	    private String role;
	    private String reportsTo; 
	    private String profileImage;
   
	    public Employee(String id, String employeeName, String phoneNumber, String email,String role, String reportsTo,
				String profileImage) {
			super();
			this.id = id;
			this.employeeName = employeeName;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.role=role;
			this.reportsTo = reportsTo;
			this.profileImage = profileImage;
		}

		// Constructors, getters, and setters

	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getReportsTo() {
			return reportsTo;
		}

		public void setReportsTo(String reportsTo) {
			this.reportsTo = reportsTo;
		}

		public String getProfileImage() {
			return profileImage;
		}

		public void setProfileImage(String profileImage) {
			this.profileImage = profileImage;
		}

		public Employee() {
	        this.id = UUID.randomUUID().toString();
	    }
	}


