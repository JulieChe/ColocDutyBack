package com.coloc_duty.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Adresse;
import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.Tache;
import com.coloc_duty.entities.User;
import com.coloc_duty.repository.TacheRepository;

@RestController
@CrossOrigin("*")
public class TacheRest {

	
	@Autowired
	private TacheRepository tacheRepo;
	
	@PostMapping("/savetache")
	public Tache saveTache(@RequestBody Tache tache) {
		Tache t = tacheRepo.save(tache);
		return t;
	}
	
	
	
}
