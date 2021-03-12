package com.coloc_duty.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.User;
import com.coloc_duty.repository.UserRepository;


@RestController @CrossOrigin("*")
public class UserRest {
	@Autowired
	private  UserRepository userRepo;
	
	@GetMapping("/connexion{login,password}")
	public  Long connexion(@PathVariable String login, @PathVariable String password) {
		List<User> list = (List<User>) userRepo.findAll();
		for (int i = 0; i<list.size();i++) {
			User u = list.get(i);
			String l = u.getLogin();
			String p = u.getPassword();
			if (l.equals(l) && p.equals(p)) {
				return u.getIdUser();
			}
		}
		
		return (long) 0;
	}

}
