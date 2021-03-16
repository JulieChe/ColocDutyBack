package com.coloc_duty.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.coloc_duty.entities.Demande;
import com.coloc_duty.entities.Mur;

public interface DemandeRepository  extends CrudRepository<Demande,Long>{
	
}
