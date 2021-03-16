package com.coloc_duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coloc_duty.entities.Adresse;
import com.coloc_duty.entities.Coloc;
import com.coloc_duty.entities.Demande;
import com.coloc_duty.entities.User;
import com.coloc_duty.repository.AdresseRepository;
import com.coloc_duty.repository.ColocRepository;
import com.coloc_duty.repository.DemandeRepository;
import com.coloc_duty.repository.UserRepository;

@SpringBootApplication
public class ColocDutyApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AdresseRepository adresseRepo;

	@Autowired
	private ColocRepository colocRepo;

	@Autowired
	private DemandeRepository demandeRepo;

	public static void main(String[] args) {
		SpringApplication.run(ColocDutyApplication.class, args);

		System.out.println("lancement terminé");

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement");

		// Test d'intégration d'utilisateur
		User u1 = new User(null, "login1", "password1", "email1", "pseudo1", "genre1", null);
		User u2 = new User(null, "login2", "password2", "email2", "pseudo2", "genre2", null);
		User u3 = new User(null, "login3", "password3", "email3", "pseudo3", "genre3", null);
		User u4 = new User(null, "login4", "password4", "email4", "pseudo4", "genre4", null);
		Adresse a1 = new Adresse(null, 2, "Alesia", "Paris", 14000);

		adresseRepo.save(a1);

		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);

		// Test d'intégration de colocation
		Coloc c1 = new Coloc(null, "nomColoc1", "descColoc1", "capacite1", "loyer1", true, a1);
		Coloc c2 = new Coloc(null, "nomColoc2", "descColoc2", "capacite2", "loyer2", true, null);
		Coloc c3 = new Coloc(null, "nomColoc3", "descColoc3", "capacite3", "loyer3", false, null);
		Coloc c4 = new Coloc(null, "nomColoc4", "descColoc4", "capacite4", "loyer4", true, null);

		colocRepo.save(c1);
		colocRepo.save(c2);
		colocRepo.save(c3);
		colocRepo.save(c4);

		// Test intégration user avec une coloc
		User u5 = new User(null, "login4", "password4", "email4", "pseudo4", "genre4", c1);
		userRepo.save(u5);

		// Test d'intégration de demande
		Demande d1 = new Demande(u1, c1, "message1", true);
		Demande d2 = new Demande(u2, c2, "message2", false);
		demandeRepo.save(d1);
		demandeRepo.save(d2);

	}

}
