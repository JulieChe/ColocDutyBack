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
		Coloc c1 = new Coloc(null, "Gemos", "la coloc des esprit de lumiere", "6", "4578", "Publique", a1);
		Coloc c2 = new Coloc(null, "La maison du sagitaire", " chasse les vierge dans la forêt", "28", "100", "Publique", null);
		Coloc c3 = new Coloc(null, "Les belier des CRS", "Macron les a gazé", "78", "50", "Publique", null);
		Coloc c4 = new Coloc(null, "Les vierges claqué au sol", "la foret qui cache des arbres peu cacher plus", "3", "102587", "Privee" ,null);
		
		colocRepo.save(c1);
		colocRepo.save(c2);
		colocRepo.save(c3);
		colocRepo.save(c4);



	// Test d'intégration d'utilisateur

		
		// Test d'intégration d'utilisateur

		User u1 = new User(null, "kangou", "junior", "kangoujunior@coloc.fr", "Kangu Junior", "M", c2, null);
		User u2 = new User(null, "castafiore", "lampion", "tintin@coloc.fr", "Lampion CASTAFIORE", "M", c3, null);
		User u3 = new User(null, "reine", "neige", "reine@neige.fr", "Rene des Neiges", "F", null, null);
		User u4 = new User(null, "maya", "abeille", "maya@abeille.fr", "Maya L'Abeille", "F", null, null);
		User u5 = new User(null, "conan", "aventure", "aventure@conan.fr", "Conan L'aventurier", "M", c2, null);

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
