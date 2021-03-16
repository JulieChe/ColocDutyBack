package com.coloc_duty.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor
@IdClass(DemandeConstraint.class)
public class Demande {
	@Id
	@ManyToOne
	private User user;
	
	@Id
	@ManyToOne
	private Coloc coloc;


	private String message;
	private boolean lu;
	


}
