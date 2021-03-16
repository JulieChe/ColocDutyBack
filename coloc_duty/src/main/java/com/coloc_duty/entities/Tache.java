package com.coloc_duty.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private Double nbEtoiles;
	private boolean ponctuel;
	
	@ManyToOne
	private Coloc coloc;
	
	@ManyToOne
	private User user;
	
}
