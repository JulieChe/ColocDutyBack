package com.coloc_duty.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coloc_duty.entities.User;
import com.coloc_duty.repository.UserRepository;


@RestController @CrossOrigin("*")
public class UserRest {
	@Autowired
	private  UserRepository userRepo;
	
	@GetMapping("/connexion")
	public  Long connexion( @RequestBody User user ) {
		List<User> list = (List<User>) userRepo.findAll();
		for (int i = 0; i<list.size();i++) {
			User u = list.get(i);
			String l = u.getLogin();
			String p = u.getPassword();
			String login = user.getLogin();
			String password = user.getPassword();
			System.out.println(login + " " + password);
			if (l.equals(login) && p.equals(password)) {
				return u.getIdUser();
			}
		}
		
		return (long) 0;
	}

}
