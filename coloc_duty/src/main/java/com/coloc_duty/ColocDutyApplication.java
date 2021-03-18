package com.coloc_duty;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coloc_duty.entities.Adresse;
import com.coloc_duty.entities.Coloc;

import com.coloc_duty.entities.Tache;

import com.coloc_duty.entities.Demande;
import com.coloc_duty.entities.Mur;

import com.coloc_duty.entities.User;
import com.coloc_duty.repository.AdresseRepository;
import com.coloc_duty.repository.ColocRepository;
import com.coloc_duty.repository.DemandeRepository;
import com.coloc_duty.repository.TacheRepository;
import com.coloc_duty.repository.MurRepository;
import com.coloc_duty.repository.UserRepository;


@SpringBootApplication
public class ColocDutyApplication implements  CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	

	@Autowired
	private AdresseRepository adresseRepo;
	
	@Autowired
	private ColocRepository colocRepo;
	
	@Autowired
	private DemandeRepository demandeRepo;
	
	@Autowired
	private TacheRepository tacheRepo;
	
	@Autowired
	private MurRepository murRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ColocDutyApplication.class, args);
		
		System.out.println("lancement terminé");
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement");
		
		
	// Test d'intégration d'adresse
		Adresse a1= new Adresse(null,2,"Alesia","Paris",14000);
		adresseRepo.save(a1);
		
		// Test d'intégration de colocation
		Coloc c1 = new Coloc(null, "nomColoc1", "descColoc1", "capacite1", "loyer1", "Publique",a1);
		Coloc c2 = new Coloc(null, "nomColoc2", "descColoc2", "capacite2", "loyer2", "Publique",null);
		Coloc c3 = new Coloc(null, "nomColoc3", "descColoc3", "capacite3", "loyer3", "Publique",null);
		Coloc c4 = new Coloc(null, "nomColoc4", "descColoc4", "capacite4", "loyer4", "Privee",null);
		
		colocRepo.save(c1);
		colocRepo.save(c2);
		colocRepo.save(c3);
		colocRepo.save(c4);



	// Test d'intégration d'utilisateur

		
		// Test d'intégration d'utilisateur

		User u1 = new User(null, "login1", "password1", "email1", "pseudo1", "genre1", c2);
		User u2 = new User(null, "login2", "password2", "email2", "pseudo2", "genre2", c3);
		User u3 = new User(null, "login3", "password3", "email3", "pseudo3", "genre3", null);
		User u4 = new User(null, "login4", "password4", "email4", "pseudo4", "genre4", null);
		User u5 = new User(null, "login5", "password5", "email5", "pseudo4", "genre5", c2);

		userRepo.save(u5);

		
		
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
		userRepo.save(u5);
	
		
		
		
	// Test d'intégration de mur
		Mur m1 = new Mur(null, "titreMur1", "contenuMur1", "https://previews.123rf.com/images/dynamoland/dynamoland1903/dynamoland190300039/120563024-nature-stone-wall-as-background.jpg", u2, c2);
		Mur m2 = new Mur(null, "titreMur2", "contenuMur2", "https://previews.123rf.com/images/truetonizz/truetonizz1709/truetonizz170900153/87160211-seamless-brick-wall-texture.jpg",u3, c2);
		Mur m3 = new Mur(null, "titreMur2", "contenuMur2", "https://previews.123rf.com/images/truetonizz/truetonizz1709/truetonizz170900153/87160211-seamless-brick-wall-texture.jpg",null, null);
		murRepo.save(m1);
		murRepo.save(m2);
		murRepo.save(m3);	

				
		

		// Test d'intégration de taches
		Tache t1 = new Tache(null, "MénageSDB", LocalDate.now(),3, "Ponctuelle", c1, null);
		Tache t2 = new Tache(null, "AspirateurSalon", LocalDate.now(), 2, "Hebdomadaire", c2, u2);
		Tache t3 = new Tache(null, "MénageCuisine", LocalDate.now(),3, "Hebdomadaire", c3, u3);
		Tache t4 = new Tache(null, "MénageCuisine", LocalDate.now(),3, "Ponctuelle", c1, u3);
		tacheRepo.save(t1);
		tacheRepo.save(t2);
		tacheRepo.save(t3);
		tacheRepo.save(t4);

		// Test d'intégration de demande
		Demande d1 = new Demande(u1, c1, "message1", true);
		Demande d2 = new Demande(u2, c2, "message2", false);
		Demande d3 = new Demande(u3, c2, "hello", false);
		Demande d4 = new Demande(u4, c2, "hey", false);
		Demande d5 = new Demande(u5, c2, "sava?", true);
		demandeRepo.save(d1);
		demandeRepo.save(d2);

		
	}
	

	
	

}
