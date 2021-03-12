package com.coloc_duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coloc_duty.entities.User;
import com.coloc_duty.repository.UserRepository;
import com.coloc_duty.rest.UserRest;


@SpringBootApplication
public class ColocDutyApplication implements  CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserRest userRest;

	public static void main(String[] args) {
		SpringApplication.run(ColocDutyApplication.class, args);
		
		System.out.println("lancement terminé");
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement");

		User u1 = new User(null, "login1", "password1", "email1", "pseudo1", "genre1");
		
		
		User u2 = new User(null, "login2", "password2", "email2", "pseudo2", "genre2");
		User u3 = new User(null, "login3", "password3", "email3", "pseudo3", "genre3");
		User u4 = new User(null, "login4", "password4", "email4", "pseudo4", "genre4");
		
		
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
	}
	
	
	
	
}
