package com.coloc_duty.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/mur/{id}")
	public List<Mur> getMurByColocId(@PathVariable Long id) {
		return murRepo.findByColocIdColoc(id);
	}

	@PostMapping("/murPoster")
	public Mur murPoster(@RequestBody Mur mur) {
		Mur mursave = new Mur(null,mur.getTitreMur(), mur.getContenuMur(),null, mur.getUser(), mur.getColoc());
		return murRepo.save(mursave); 
	}
	
	@DeleteMapping("/murDelete/{id}")
	public void murDelete(@PathVariable Long id) {
		Mur mur = murRepo.findById(id).get(); 
		murRepo.delete(mur);
	}

}
