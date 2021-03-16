package com.coloc_duty.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@ManyToOne
	private Coloc coloc;
	
	@OneToOne
	private Mur mur;
	
	
}
