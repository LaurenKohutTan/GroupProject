package com.example.SpringbootThymeleafForm;


public class User {
	 private String firstName;
	 private String lastName;
	 private String Period;
	 
	    
	

	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getPeriod() {
		return Period;
	}




	public void setPeriod(String period) {
		Period = period;
	}




	@Override
	public String toString() {
		return "User [name=" + firstName + " " + lastName + ", Period=" + Period + "]";
	 
}
}