package com.coloc_duty.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Demande;
import com.coloc_duty.repository.DemandeRepository;

@RestController
@CrossOrigin("*")
public class DemandeRest {
	@Autowired
	private DemandeRepository demandeRepo;

	@GetMapping("/demandes")
	public List<Demande> getAllDemandes() {
		return (List<Demande>) demandeRepo.findAll();

	}

	@PostMapping("/savedemande")
	public Demande saveDemande(@RequestBody Demande demande) {
		return demandeRepo.save(demande);
	}

	

}
