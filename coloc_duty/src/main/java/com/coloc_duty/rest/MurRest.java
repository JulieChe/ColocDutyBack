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
import com.coloc_duty.entities.Mur;
import com.coloc_duty.entities.User;
import com.coloc_duty.repository.ColocRepository;
import com.coloc_duty.repository.MurRepository;

@RestController
@CrossOrigin("*")
public class MurRest {
	@Autowired
	private MurRepository murRepo;
	
	@Autowired
	private ColocRepository colocRepo;

	@GetMapping("/murs")
	public List<Mur> getAllMurs() {
		return (List<Mur>) murRepo.findAll();

	}

	@PostMapping("/savemur")
	public Mur saveMur(@RequestBody Mur mur) {
		return murRepo.save(mur);
	}
	
	

	

}
