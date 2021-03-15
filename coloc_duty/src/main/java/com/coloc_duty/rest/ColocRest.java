package com.coloc_duty.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Coloc;
import com.coloc_duty.repository.ColocRepository;

@RestController
@CrossOrigin("*")
public class ColocRest {
	@Autowired
	private ColocRepository colocRepo;

	@GetMapping("/coloc")
	public List<Coloc> getAllColocs() {
		return (List<Coloc>) colocRepo.findAll();

	}

	@PostMapping("/savecoloc")
	public Coloc saveColoc(@RequestBody Coloc coloc) {
		return colocRepo.save(coloc);
	}

	@PostMapping("/getColoc") 
	public Optional<Coloc> getColoc(@RequestBody Long idColoc) {
		
		return colocRepo.findById(idColoc);
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
