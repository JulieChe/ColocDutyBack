package com.coloc_duty.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor
@Data
public class Adresse {

	@Id
	@GeneratedValue
	private Long idAdresse;
	private int numVoie;
	private String nomRue;
	private String ville;

}
