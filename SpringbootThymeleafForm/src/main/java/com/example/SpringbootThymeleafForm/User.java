package com.example.SpringbootThymeleafForm;


public class User {
	 private String name;
	 private String Period;
	 
	    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriod() {
		return Period;
	}

	public void setPeriod(String period) {
		Period = period;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", Period=" + Period + "]";
	 
}
}