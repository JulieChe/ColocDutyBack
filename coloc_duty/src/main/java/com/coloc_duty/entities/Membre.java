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
	private Long nbEtoiles;
	
	

	@Override
	public String toString() {
		return "Membre [idUser=" + idUser + ", nbEtoiles=" + nbEtoiles + "]";
	}
	
	


}
