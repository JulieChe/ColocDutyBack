package com.coloc_duty.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor
@Data
public class User {
	
	@Id @GeneratedValue
	private Long idUser;
	private String login;
	private String password;
	private String email;
	private String pseudo;
	private String genre;
	
	public User(String login,String password) {
		this.login=login;
		this.password=password;
	}
	
}
