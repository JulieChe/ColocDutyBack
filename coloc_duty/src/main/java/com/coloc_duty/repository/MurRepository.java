package com.coloc_duty.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.Mur;


public interface MurRepository  extends CrudRepository<Mur,Long>{

	public Optional<Mur> findByIdMur(Long idMur);
	
	public Optional<Mur> findByColoc(Coloc coloc);
	
	
}
