package com.coloc_duty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.Tache;
import com.coloc_duty.entities.User;

public interface TacheRepository extends CrudRepository<Tache, Long>{

	public Optional<Tache> findByUser(User user);
	
	public Optional<Tache> findByColoc(Coloc coloc);
	
	
}
