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
import com.coloc_duty.entities.Mur;
import com.coloc_duty.entities.User;
import com.coloc_duty.repository.AdresseRepository;

import com.coloc_duty.repository.ColocRepository;
import com.coloc_duty.repository.MurRepository;
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

	@Autowired
	private MurRepository murRepo;

	@GetMapping("/coloc")
	public List<Coloc> getAllColocs() {
		return (List<Coloc>) colocRepo.findAll();

	}

	@PostMapping("/savecoloc/{id}")
	public Coloc saveColoc(@RequestBody Coloc coloc, @PathVariable Long id) {
		Coloc col = new Coloc();
		Adresse a = adresseRepo.save(coloc.getAdresse());
		coloc.setAdresse(a);
		Optional<User> u = userRepo.findById(id);

		if (u.get().getColoc() != null) {
			return col;
		} else {
			Coloc c = colocRepo.save(coloc);

			u.get().setColoc(c);

			userRepo.save(u.get());
			return c;
		}

	}

	@PostMapping("/getColoc")
	public Optional<Coloc> getColoc(@RequestBody Long idColoc) {

		return colocRepo.findById(idColoc);
	}

	@PostMapping("/getidColocbyidUser")
	public Long getIdColocByIdUser(@RequestBody Long idUser) {
		User user = userRepo.findByIdUser(idUser).get();
		if (user.getColoc() != null) {
			Long idColoc = user.getColoc().getIdColoc();
			return idColoc;
		} else {
			return Long.valueOf(0);
		}
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
//	@GetMapping("/gotocoloc")
//	public String subscribed(@RequestBody Coloc coloc) {
//		List<Coloc> l = getAllColocs();
//		String p = "errorColoc";
//		int i = 0;
//		while (i < l.size() && p.equals("errorColoc")) {
//			if (l.get(i).getIdColoc() == (coloc.getIdColoc())) {
//				p = "colocExist";
//			}
//			i++;
//		}
//		return p;
//	}

	@PostMapping("/idColoc_ok")
	public Optional<Coloc> idColoc_ok(@RequestBody Coloc u) {
		return colocRepo.findByIdColoc(u.getIdColoc());

	}

	@PostMapping("/getidColocbyidMur")
	public Long getIdColocByIdMur(@RequestBody Long idMur) {
		Mur mur = murRepo.findByIdMur(idMur).get();
		if (mur.getUser().getColoc() != null) {
			Long idColoc = mur.getUser().getColoc().getIdColoc();
			return idColoc;
		} else {
			return Long.valueOf(0);
		}
	}

/*	@PostMapping("/getMurbyidColoc")
	public Optional<Mur> getMurByIdColoc(@RequestBody Long idColoc) {
		Coloc coloc = colocRepo.findByIdColoc(idColoc).get(); // rechercher la coloc
		System.out.println(murRepo.findByColoc(coloc));
		List<Mur> l = murRepo.findByColoc(coloc);
		if (l != null) {
			return l;
		} else {
			return Optional.empty();
		}
	}
*/
}
