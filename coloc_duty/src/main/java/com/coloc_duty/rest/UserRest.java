package com.coloc_duty.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();

	}

	@PostMapping("/saveuser")
	public User saveUser(User user) {
		return userRepo.save(user);

	}

	@GetMapping("/signin")
	public String subscribed(@RequestBody User user) {
		List<User> l = getAllUsers();
		String p = null;
		int i = 0;
		System.out.println("le login du user à ajouter est : " + user.getLogin());
		System.out.println("le mail du user à ajouter est : " + user.getEmail());
		while (i < l.size() && p == null) {
			if (l.get(i).getLogin().equals(user.getLogin())) {
				p = "errorLogin";
			}
			if (l.get(i).getEmail().equals(user.getEmail())) {
				p = "errorEmail";
			}
			if (l.get(i).getLogin().equals(user.getLogin()) && l.get(i).getEmail().equals(user.getEmail())) {
				p="errorBoth";
				
			}
			i++;
			System.out.println("Le login du user : " + i + " est : " + l.get(i - 1).getLogin());
		}
		return p;
	}
	

}
