package com.coloc_duty.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Ids {
	private Long idUser;
	private Long idColoc;

	public Ids(Long idUser, Long idColoc) {
		this.idUser = idUser;
		this.idColoc = idColoc;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdColoc() {
		return idColoc;
	}

	public void setIdColoc(Long idColoc) {
		this.idColoc = idColoc;
	}
	
}
