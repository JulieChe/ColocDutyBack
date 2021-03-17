package com.coloc_duty.rest;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.Tache;
import com.coloc_duty.entities.User;
import com.coloc_duty.repository.ColocRepository;
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
	
	
	   
	        
	@PostMapping("/getEtoilesUser")
	public int[] getEtoilesUser(@RequestBody Long idUser) {

		int []e= {0};
		
		List<Tache> l = new ArrayList<Tache>();
		List<Tache> allTaches = getAllTaches();
		allTaches.forEach(t -> {
			if (t.getUser() != null) {
				if (t.getUser().getIdUser() == idUser) {
					l.add(t);
					e[0]= e[0]+(t.getNbEtoiles());
				}
			}
		});
		return e;
	}


}
