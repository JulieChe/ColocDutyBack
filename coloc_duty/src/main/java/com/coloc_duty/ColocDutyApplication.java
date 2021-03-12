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
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement");

		User u1 = new User(null, "login", "password", "email", "pseudo", "genre");
		userRepo.save(u1);

	}
}
