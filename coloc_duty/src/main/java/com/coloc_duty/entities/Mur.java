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
public class Mur {
	
	@Id @GeneratedValue
	private Long idMur;
	private String titreMur;
	private String contenuMur;
	private String photoMur;

	@ManyToOne
	private User user;

}
