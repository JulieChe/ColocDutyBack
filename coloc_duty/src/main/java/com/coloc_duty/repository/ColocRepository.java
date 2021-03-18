package com.coloc_duty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coloc_duty.entities.Adresse;
import com.coloc_duty.entities.Coloc;


public interface ColocRepository  extends CrudRepository<Coloc,Long>{
		
	public Optional<Coloc> findByIdColoc(Long idColoc);
	
	//--------------------------------------------------------Query niveau 1 -----------------------------------------------
	
	public List<Coloc> findByCapacite(String capacite);
	
	public List<Coloc> findByLoyer(String loyer);
	
	//@Query(value = "select c,a from Coloc c inner join Adresse a where a.ville =?1")
	public List<Coloc> findByAdresseVille(String ville);
	
	//--------------------------------------------------------Query niveau 2 -----------------------------------------------
	
//	@Query(value = "select c from Coloc c inner join Adresse a where c.loyer=?1 and a.ville =?2")
	public List<Coloc> findByLoyerAndAdresseVille(String loyer, String ville);
	
//	@Query(value = "select c from Coloc c inner join Adresse a where c.capacite=?1 and a.ville =?2")
	public List<Coloc> findByCapaciteAndAdresseVille(String capacite, String ville);
	

	public List<Coloc> findByLoyerAndCapacite(String loyer, String capacite);	
	
	
	//--------------------------------------------------------Query niveau 3 -----------------------------------------------
	
//	@Query(value = "select c from Coloc c inner join Adresse a where c.capacite=?1 and c.loyer=?2 and a.ville =?3")
	public List<Coloc> findByCapaciteAndLoyerAndAdresseVille(String capacite, String loyer, String ville);
	
}