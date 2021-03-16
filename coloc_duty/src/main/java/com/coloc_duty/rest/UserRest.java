package com.coloc_duty.rest;

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
import com.coloc_duty.entities.Ids;
import com.coloc_duty.entities.User;
import com.coloc_duty.repository.ColocRepository;
import com.coloc_duty.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserRest {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ColocRepository colocRepo;

	@PostMapping("/setColocToUser")
	public User setColocToUser(User uInput) {
		Optional<User> uOutput = userRepo.findById(uInput.getIdUser());
		uOutput.get().setColoc(uInput.getColoc());
		return uOutput.get();

	}

	@GetMapping("/connexion")
	public Long connexion(@RequestBody User user) {
		List<User> list = (List<User>) userRepo.findAll();
		for (int i = 0; i < list.size(); i++) {
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

	@PostMapping("/connexion_ok")
	public Optional<User> connexion_ok(@RequestBody User u) {

		return userRepo.findByLoginAndPassword(u.getLogin(), u.getPassword());
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();

	}
	
	@PostMapping("/getUser")
	public Optional<User> getUser(@RequestBody Long idUser) {

		return userRepo.findById(idUser);
	}

	@PostMapping("/getUsersByIdColoc")
	public List<User> getAllUserByIdColoc(@RequestBody Long idColoc) {
		List<User> l = new ArrayList<User>();
		List<User> allUser = getAllUsers();
		allUser.forEach(p -> {
			if (p.getColoc() != null) {
				if (p.getColoc().getIdColoc() == idColoc) {
					l.add(p);
				}
			}
		});
		return l;
	}

//	@PostMapping("/saveuser")
//	public User saveUser(@RequestBody User user) {
//
//		return userRepo.save(user);
//
//	}

//	@PostMapping("/signin")
//	public String subscribed(@RequestBody User user) {
//		List<User> l = getAllUsers();
//		String p = null;
//		int i = 0;
//		while (i < l.size() && p == null) {
//			if (l.get(i).getLogin().equals(user.getLogin())) {
//				p = "errorLogin";
//			}
//			if (l.get(i).getEmail().equals(user.getEmail())) {
//				p = "errorEmail";
//			}
//			if (l.get(i).getLogin().equals(user.getLogin()) && l.get(i).getEmail().equals(user.getEmail())) {
//				p = "errorBoth";
//			}
//			i++;
//		}
//		return p;
//	}

	@PostMapping("/inscription")
	public String inscription(@RequestBody User user) {
		Optional<User> userTestByLogin = userRepo.findByLogin(user.getLogin()); // test du login
		Optional<User> userTestByEmail = userRepo.findByEmail(user.getEmail());
		if (userTestByLogin.isPresent()) {
			return "errorLogin";
		} else if (userTestByEmail.isPresent()) {
			return "errorEmail";
		} else {
			userRepo.save(user);
			return "utilisateur créé";
		}

	}

	
	@PostMapping("/affecterColoc/{userId}")
	public void affecterColoc(@RequestBody Coloc coloc, @PathVariable Long userId) {
		Optional<User> user = userRepo.findById(userId); 
		user.get().setColoc(coloc);
	}
	
	@PutMapping("/user/{id}")
	public User modifUser(@RequestBody User u, @PathVariable Long id) {
		Optional<Coloc> coloc = colocRepo.findById(u.getColoc().getIdColoc());
		if(coloc.isPresent()) {
			u.setIdUser(id);
			System.out.println(u.toString());
			return userRepo.save(u);
		}
		else {
			return u;
		}
		
	}
	
	

}
