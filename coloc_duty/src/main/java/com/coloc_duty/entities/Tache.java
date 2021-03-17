package com.coloc_duty.entities;

import java.time.LocalDate;
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
public class Tache {

	
	@Id @GeneratedValue
	private Long idTache;
	private String nomTache;
	private LocalDate date;
	private int nbEtoiles;
	private String frequence;
	
	@OneToOne
	private Coloc coloc;
	
	@OneToOne
	private User user;
	
}
