package com.coloc_duty.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Demande;
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
				if (d.getColoc().getIdColoc() == idColoc) {
					demandesC.add(d);
				}
			}
		});
		return demandesC;
	}

	@GetMapping("/demandesNL")
	public List<Demande> getAllDemandesNLbyColoc(@RequestBody Long idColoc) {
		List<Demande> demandes = getAllDemandesByIdColoc(idColoc);
		List<Demande> demandesNL = new ArrayList<Demande>();
		for (int i = 0; i < demandes.size(); i++) {
			if (demandes.get(i).isLu() == false) {
				demandesNL.add(demandes.get(i));
			}
		}
		return demandesNL;
	}

	@GetMapping("/demandesL")
	public List<Demande> getAllDemandesLbyColoc(@RequestBody Long idColoc) {
		List<Demande> demandes = getAllDemandesByIdColoc(idColoc);
		List<Demande> demandesL = new ArrayList<Demande>();
		for (int i = 0; i < demandes.size(); i++) {
			if (demandes.get(i).isLu() == true) {
				demandesL.add(demandes.get(i));
			}
		}
		return demandesL;
	}

}
