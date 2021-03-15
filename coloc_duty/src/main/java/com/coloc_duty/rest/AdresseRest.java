package com.coloc_duty.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Adresse;
import com.coloc_duty.entities.Coloc;
import com.coloc_duty.repository.AdresseRepository;
import com.coloc_duty.repository.ColocRepository;

@RestController
@CrossOrigin("*")
public class AdresseRest {

	@Autowired
	private AdresseRepository adresseRepo;
	
	@PostMapping("/saveAdresse")
	public Adresse saveAdresse(@RequestBody Adresse adresse) {
		return adresseRepo.save(adresse);
	}
}
