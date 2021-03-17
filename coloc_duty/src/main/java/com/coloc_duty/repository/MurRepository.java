package com.coloc_duty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.Mur;


public interface MurRepository  extends CrudRepository<Mur,Long>{

	public Optional<Mur> findByIdMur(Long idMur);
	
	//public List<Mur> findByColoc(Coloc coloc);
	
	public List<Mur> findByColocIdColoc(Long idColoc);
	
	
}
