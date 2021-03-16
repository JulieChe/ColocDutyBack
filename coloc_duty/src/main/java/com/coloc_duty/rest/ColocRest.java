package com.coloc_duty.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Adresse;
import com.coloc_duty.entities.Coloc;

import com.coloc_duty.entities.User;
import com.coloc_duty.repository.AdresseRepository;

import com.coloc_duty.repository.ColocRepository;
import com.coloc_duty.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class ColocRest {
	
	@Autowired
	private AdresseRepository adresseRepo;
	
	@Autowired
	private ColocRepository colocRepo;
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/coloc")
	public List<Coloc> getAllColocs() {
		return (List<Coloc>) colocRepo.findAll();

	}

	@PostMapping("/savecoloc/{id}")
	public Coloc saveColoc(@RequestBody Coloc coloc, @PathVariable Long id) {
		Adresse a = adresseRepo.save(coloc.getAdresse());
		coloc.setAdresse(a);
		
		Coloc c = colocRepo.save(coloc);
		Optional<User> u = userRepo.findById(id);
		u.get().setColoc(c);
		
		userRepo.save(u.get());
		return c;
	}

	@GetMapping("/gotocoloc")
	public String subscribed(@RequestBody Coloc coloc) {
		List<Coloc> l = getAllColocs();
		String p = "errorColoc";
		int i = 0;
		while (i < l.size() && p.equals("errorColoc")) {
			if (l.get(i).getIdColoc() == (coloc.getIdColoc())) {
				p = "colocExist";
			}
			i++;
		}
		return p;
	}

}
