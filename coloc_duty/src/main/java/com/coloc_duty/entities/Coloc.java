package com.coloc_duty.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor
@Data
public class Coloc {
	
	@Id @GeneratedValue
	private Long idColoc;
	private String nomColoc;
	private String descColoc;
	private String capacite;
	private String loyer;
	private boolean isPublic;
}
