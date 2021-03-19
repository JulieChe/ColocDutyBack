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
public class Membre {
	
	@Id @GeneratedValue
	private Long idMembre;
	private Long idUser;
	private String name;
	private Long nbEtoiles;
	private double y;
	
	

	@Override
	public String toString() {
		return "Membre [idUser=" + idUser + ", nbEtoiles=" + nbEtoiles + "]";
	}
	
	


}
