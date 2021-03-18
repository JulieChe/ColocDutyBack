package com.coloc_duty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.Adresse;
import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.Membre;


public interface MembreRepository  extends CrudRepository<Membre,Long>{
		
	
}