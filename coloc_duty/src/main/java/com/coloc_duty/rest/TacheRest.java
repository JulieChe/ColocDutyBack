package com.coloc_duty.rest;

import java.time.LocalDate;
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

import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.Tache;
import com.coloc_duty.entities.User;
import com.coloc_duty.repository.ColocRepository;
import com.coloc_duty.repository.TacheRepository;
import com.coloc_duty.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class TacheRest {

	@Autowired
	private TacheRepository tacheRepo;
	
	@Autowired
	private UserRepository userRepo;


	@PostMapping("/savetache")
	public Tache saveTache(@RequestBody Tache tache) {
		Tache t = tacheRepo.save(tache);
		return t;
	}
	

	@Autowired
	private ColocRepository colocRepo;

	@PostMapping("/addTache")
	public Tache createTache(@RequestBody Tache tache) {
		return tacheRepo.save(tache);

	}

	@GetMapping("/getAllTaches")
	public List<Tache> getAllTaches() {
		return (List<Tache>) tacheRepo.findAll();
	}

	@PostMapping("/getTachesColoc")
	public List<Tache> getTachesByColoc(@RequestBody Long idColoc) {
		List<Tache> l = new ArrayList<Tache>();
		List<Tache> allTaches = getAllTaches();
		allTaches.forEach(t -> {
			if (t.getColoc() != null) {
				if (t.getColoc().getIdColoc() == idColoc) {
					l.add(t);
				}
			}
		});
		return l;
	}
	
	@PutMapping("/updateTache/{id}")
	public Tache modifTache(@RequestBody Tache t, @PathVariable Long id) {
		Optional<User> u = userRepo.findById(id);
		t.setUser(u.get());
		System.out.println(t.toString());
		return tacheRepo.save(t);

	}
	
	@PutMapping("/resetTache")
	public void resetTache(@RequestBody Coloc coloc) {
		List<Tache> list = (List<Tache>) tacheRepo.findAll();
		for (Tache tache : list) {
			if (tache.getColoc().getIdColoc().equals(coloc.getIdColoc())) {
				if (tache.getFrequence().equals("Hebdomadaire") ) {
					tache.setUser(null);
					tacheRepo.save(tache);
				} else {
					tacheRepo.delete(tache);
				}
			}
		}
	}

}
