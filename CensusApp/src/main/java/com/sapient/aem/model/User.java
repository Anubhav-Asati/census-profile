package com.sapient.aem.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//POJO class, a domain object
//@AllArgsConstructor;
//@NoArgsConstructor;
@Getter
@Setter
@ToString
//


public class User implements Serializable {

	private Integer userId;
	private String userName;
	private String password;
	private Role role;
	
	

	public User(Integer userId, String userName, String password, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
