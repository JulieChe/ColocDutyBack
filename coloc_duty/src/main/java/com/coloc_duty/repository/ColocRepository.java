package com.coloc_duty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.Adresse;
import com.coloc_duty.entities.Coloc;


public interface ColocRepository  extends CrudRepository<Coloc,Long>{
	

	
	public Optional<Coloc> findByIdColoc(Long idColoc);
	
	public List<Coloc> findByCapacite(String capacite);
	
	public List<Coloc> findByLoyer(String loyer);
	
	public List<Coloc> findByAdresse(Adresse adresse);
	
}