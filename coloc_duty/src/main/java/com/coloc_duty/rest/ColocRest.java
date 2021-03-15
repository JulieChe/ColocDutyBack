package com.coloc_duty.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.User;
import com.coloc_duty.repository.ColocRepository;


@RestController @CrossOrigin("*")
public class ColocRest {
	@Autowired
	private  ColocRepository colocRepo;
	
	
	@GetMapping("/coloc")
	public List<Coloc> getAllColocs() {
		return (List<Coloc>) colocRepo.findAll();

	}
	
	@PostMapping("/savecoloc")
	public Coloc saveColoc(@RequestBody Coloc coloc) {
		return colocRepo.save(coloc);
	}

//	@GetMapping("/gotocoloc")
//	public String subscribed(@RequestBody Coloc	coloc) {
//		List<Coloc> l = getAllColocs();
//		String p = null;
//		int i = 0;
//		while (i < l.size() && p == null) {
//			if (l.get(i).getIdColoc().equals(coloc.getIdColoc())) {
//				p = "errorLogin";
//			}
//			if (l.get(i).getEmail().equals(user.getEmail())) {
//				p = "errorEmail";
//			}
//			if (l.get(i).getLogin().equals(user.getLogin()) && l.get(i).getEmail().equals(user.getEmail())) {
//				p="errorBoth";
//			}
//			i++;
//		}
//		return p;
//	}
	
}
