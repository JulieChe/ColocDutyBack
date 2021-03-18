package com.coloc_duty.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.Coloc;


public interface ColocRepository  extends CrudRepository<Coloc,Long>{
		
	public Optional<Coloc> findByIdColoc(Long idColoc);
	
	
	
}