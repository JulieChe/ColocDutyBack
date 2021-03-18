package com.coloc_duty.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Demande;
import com.coloc_duty.entities.Tache;
import com.coloc_duty.entities.User;
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
	
	@PostMapping("/getDemandesByIdColoc")
	public List<Demande> getAllDemandesByIdColoc(@RequestBody Long idColoc) {
		List<Demande> demandes = getAllDemandes();
		List<Demande> demandesC = new ArrayList<Demande>();
		demandes.forEach(d -> {
			if (d.getColoc() != null) {
				if (d.getColoc().getIdColoc().equals(idColoc) ) {
					demandesC.add(d);
				}
			}
		});
		return demandesC;
	}

	@PostMapping("/demandesNL")
	public List<Demande> getAllDemandesNLbyColoc(@RequestBody Long idColoc) {
		List<Demande> demandes = getAllDemandesByIdColoc(idColoc);
		List<Demande> demandesNL = new ArrayList<Demande>();
		demandes.forEach(d ->{
			if (d.isLu() == false) {
				demandesNL.add(d);
			}
		}); 
		return demandesNL;
	}
	
	@PostMapping("/nbDemandesNL")
	public int countDemandesNLbyColoc(@RequestBody Long idColoc) {
		List<Demande> demandes = getAllDemandesByIdColoc(idColoc);
		List<Demande> demandesNL = new ArrayList<Demande>();
		demandes.forEach(d ->{
			if (d.isLu() == false) {
				demandesNL.add(d);
			}
		}); 
		return demandesNL.size();
	}

	@PostMapping("/demandesL")
	public List<Demande> getAllDemandesLbyColoc(@RequestBody Long idColoc) {
		List<Demande> demandes = getAllDemandesByIdColoc(idColoc);
		List<Demande> demandesL = new ArrayList<Demande>();
		demandes.forEach(d ->{
			if (d.isLu() == true) {
				demandesL.add(d);
			}
		}); 
		return demandesL;
	}
	
	@PutMapping("/marqLu")
	public Demande marqLu(@RequestBody Demande d) {
		d.setLu(true);
		return demandeRepo.save(d);

	}
	
	@PutMapping("/marqNLu")
	public Demande marqNLu(@RequestBody Demande d) {
		d.setLu(false);
		return demandeRepo.save(d);

	}

}
