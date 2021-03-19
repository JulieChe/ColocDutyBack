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
		
		Adresse a1= new Adresse(null,6,"Avenue des Champs-Elysées","Paris",75008);
		Adresse a2= new Adresse(null,5,"Avenue Anatole France","Paris",75007);
		Adresse a3= new Adresse(null,2,"Place du Cardinal Luçon","Reims",51100);
		Adresse a4= new Adresse(null,35,"Rue du Chevalier de la Barre","Paris",75018);
		Adresse a5= new Adresse(null,1,"Place d'Armes","Versailles",78000);
		
		adresseRepo.save(a1);
		adresseRepo.save(a2);
		adresseRepo.save(a3);
		adresseRepo.save(a4);
		adresseRepo.save(a5);
		
		// Test d'intégration de colocation
		
		Coloc c1 = new Coloc(null, "Les Champs-Elysées", "Bienvenue dans la coloc des Champs-Elysées !", "6", "550", "Publique", a1);
		Coloc c2 = new Coloc(null, "Tour Eiffel", "Ici, nous avons une vue imprenable sur la Tour Eiffel !", "3", "800", "Publique", a2);
		Coloc c3 = new Coloc(null, "Cathédrale de Reims", "Dans cette coloc, vous aurez la chance de voir la cathédrale de raims depuis votre lit.", "4", "750", "Publique", a3);
		Coloc c4 = new Coloc(null, "Le Sacré-Coeur", "Visite gratuite du Sacré-Coeur pour tous les colocataires !", "3", "950", "Privee" ,a4);
		Coloc c5 = new Coloc(null, "Le Château de Versailles", "On dit que le Roi Louis XIV en personne a dormi dans la chambre 2", "5", "850", "Privee" ,a5);
		
		colocRepo.save(c1);
		colocRepo.save(c2);
		colocRepo.save(c3);
		colocRepo.save(c4);
		colocRepo.save(c5);

		
		// Test d'intégration d'utilisateur

		User u1 = new User(null, "Marie Dupuis", "password", "mariedupuis@email.fr", "MarieD", "F", c1, null);
		User u2 = new User(null, "Laurent Tanin", "password", "l.tanin@email.fr", "LaurentTanin", "M", c1, null);
		User u3 = new User(null, "Paul Antoine", "password", "paulantoine@email.fr", "PA", "M", c2, null);
		User u4 = new User(null, "Quentin Delorme", "password", "qdelorme@email.fr", "Quentin.Delorme", "M", c2, null);
		User u5 = new User(null, "Inès Deschamps", "password", "deschampsines@email.fr", "Inès", "F", c2, null);
		User u6 = new User(null, "Martin Deneb", "password", "deneb@email.fr", "Martin.De", "M", c3, null);
		User u7 = new User(null, "Justine cros", "password", "cros.justine25@email.fr", "Jujustine", "f", c4, null);
		User u8 = new User(null, "Anna Durand", "password", "ananas78@email.fr", "Anna-nas", "F", null, null);
		User u9 = new User(null, "Roger Gayo", "password", "gayo.roger1@email.fr", "Rogerger", "M", c5, null);
		User u10 = new User(null, "Arthur Ruck", "password", "ruck28@email.fr", "Arthuraventure", "M", c5, null);
		User u11 = new User(null, "Martine Youry", "password", "martine.y@email.fr", "MartineY", "F", null, null);
		User u12 = new User(null, "Louise Gatinez", "password", "gatinez.louise3@email.fr", "Louise.Ga", "F", null, null);
		User u13 = new User(null, "Jeanne Grand", "password", "grand.jeanne23@email.fr", "Jeannette", "F", null, null);
		User u14 = new User(null, "Anna Smith", "password", "annasmith@email.fr", "AnnainParis", "F", null, null);
		User u15 = new User(null, "Maurine Talot", "password", "maurine.rine@email.fr", "Maurine.rine", "F", null, null);
		User u16 = new User(null, "Corinne Frole", "password", "corrineF@email.fr", "Coco78", "F", null, null);
	
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
		userRepo.save(u5);
		userRepo.save(u6);
		userRepo.save(u7);
		userRepo.save(u8);
		userRepo.save(u9);
		userRepo.save(u10);
		userRepo.save(u11);
		userRepo.save(u12);
		userRepo.save(u13);
		userRepo.save(u14);
		userRepo.save(u15);
		userRepo.save(u16);

	// Test d'intégration de mur
		Mur m1 = new Mur(null, "Hello la coloc !", "Je suis ravi d'intégrer la colocation, j'espère que les champs seront à la hauteur de mes espérances !", null, u2, c1);
		Mur m2 = new Mur(null, "Petite joie du matin", "On dirait que ce matin tout était bien rangé dans la coloc ! C'est une bonne nouvelle !", null,u1, c1);
		Mur m3 = new Mur(null, "Ce matin", "Il faudrait emmener le chat chez le vétérinaire ?", null,u3, c2);
		Mur m4 = new Mur(null, "Cuisine", "Attention au dernier qui a utilisé la cuisine, il reste du ménage à faire", null, u4, c2);
		Mur m5 = new Mur(null, "Re: Cuisine", "Je suis passée pour nettoyer", null, u5, c2);
		Mur m6 = new Mur(null, "", "Les étagères sont maintenant à leur place", null,u4, c2);
		Mur m7 = new Mur(null, "Meubles", "Je pense qu'il qu'il faudrait ajouter des meubles dans le salon", null, u6, c3);
		Mur m8 = new Mur(null, "Meubles", "Je crois qu'un petit canapé neuf ne serait pas du luxe...", null,u6, c3);
		Mur m9 = new Mur(null, "Question", "Personne n'utilise le mur ?", null,u7, c4);
		Mur m10 = new Mur(null, "Vaiselle", "Je crois que personne n'a fait la vaisselle ce matin ? Une personne charitable pourrait-elle se dévouer ?", null, u9, c5);
		Mur m11 = new Mur(null, "Fait !", "Ca y est c'est fait ! La vaisselle est propre !", null,u10, c5);
		Mur m12 = new Mur(null, "Bonne journée !", "Je vous souhaite une bonne journée à tous !", null,u9, c5);
		
		murRepo.save(m1);
		murRepo.save(m2);
		murRepo.save(m3);	
		murRepo.save(m4);
		murRepo.save(m5);
		murRepo.save(m6);
		murRepo.save(m7);
		murRepo.save(m8);
		murRepo.save(m9);
		murRepo.save(m10);
		murRepo.save(m11);
		murRepo.save(m12);

		// Test d'intégration de taches
		Tache t1 = new Tache(null, "Ranger les armoires", LocalDate.now(),5, "Ponctuelle", c1, null);
		Tache t2 = new Tache(null, "AspirateurSalon", LocalDate.now(), 2, "Hebdomadaire", c1, u2);
		Tache t3 = new Tache(null, "MénageCuisine", LocalDate.now(),3, "Hebdomadaire", c2, u3);
		Tache t4 = new Tache(null, "MénageCuisineAJAX", LocalDate.now(),4, "Ponctuelle", c2, u3);
		Tache t5 = new Tache(null, "MénageSDB", LocalDate.now(),3, "Hebdomadaire", c2, null);
		Tache t6 = new Tache(null, "AspirateurSalon", LocalDate.now(), 2, "Hebdomadaire", c3, u6);
		Tache t7 = new Tache(null, "MénageCuisine", LocalDate.now(),3, "Hebdomadaire", c4, null);
		Tache t8 = new Tache(null, "MénageEntrée", LocalDate.now(),1, "Ponctuelle", c4, u7);
		Tache t9 = new Tache(null, "MénageChambreAmis", LocalDate.now(),3, "Ponctuelle", c5, null);
		Tache t10 = new Tache(null, "AspirateurSalon", LocalDate.now(), 2, "Hebdomadaire", c5, u9);
		Tache t11 = new Tache(null, "MénageSDC", LocalDate.now(),4, "Hebdomadaire", c5, u9);
		Tache t12 = new Tache(null, "MénageCuisine", LocalDate.now(),3, "Hebdomadaire", c5, u10);
		Tache t13 = new Tache(null, "Ranger les armoires", LocalDate.now(),5, "Ponctuelle", c1, null);
		Tache t14 = new Tache(null, "AspirateurSalon", LocalDate.now(), 2, "Hebdomadaire", c1, null);
		Tache t15 = new Tache(null, "Changer la litière du chat", LocalDate.now(),3, "Hebdomadaire", c2, null);
		Tache t16 = new Tache(null, "Sortir le chein", LocalDate.now(),4, "Ponctuelle", c2, null);
		Tache t17 = new Tache(null, "Passer le chiffon dans les placards", LocalDate.now(),3, "Hebdomadaire", c2, null);
		Tache t18 = new Tache(null, "Ranger le Lave Vaisselle", LocalDate.now(), 2, "Hebdomadaire", c3, null);
		Tache t19 = new Tache(null, "Aménager le salon", LocalDate.now(),3, "Pontuelle", c2, null);
		Tache t20 = new Tache(null, "Sortir la poubelle", LocalDate.now(),2, "Ponctuelle", c2, null);
		Tache t21 = new Tache(null, "Mettre au frais les bouteilles de bière", LocalDate.now(),3, "Ponctuelle", c2, null);
		Tache t22 = new Tache(null, "Remplir le Lave Vaisselle", LocalDate.now(), 2, "Hebdomadaire", c3, null);
		
		tacheRepo.save(t1);
		tacheRepo.save(t2);
		tacheRepo.save(t3);
		tacheRepo.save(t4);
		tacheRepo.save(t5);
		tacheRepo.save(t6);
		tacheRepo.save(t7);
		tacheRepo.save(t8);
		tacheRepo.save(t9);
		tacheRepo.save(t10);
		tacheRepo.save(t11);
		tacheRepo.save(t12);
		tacheRepo.save(t13);
		tacheRepo.save(t14);
		tacheRepo.save(t15);
		tacheRepo.save(t16);
		tacheRepo.save(t17);
		tacheRepo.save(t18);
		tacheRepo.save(t19);
		tacheRepo.save(t20);
		tacheRepo.save(t21);
		tacheRepo.save(t22);

		// Test d'intégration de demande
		Demande d1 = new Demande(u11, c1, "Bonjour, j'aimerais beaucoup rejoindre votre coloc !", true);
		Demande d2 = new Demande(u12, c1, "Hello, serait-il possible de se rencontrer pour faire plus ample connaissance ?", false);
		Demande d3 = new Demande(u13, c2, "Bonjour à tous, y a t il de la place dans votre coloc ? ", false);
		Demande d4 = new Demande(u11, c2, "Hello, voici mon email pour me contacter. Je recherche activement une coloc dans la région !", false);
		Demande d5 = new Demande(u12, c3, "Salut, j'ai 25 ans et je cherche une colocation. La votre a l'air très sympa !", true);
		Demande d6 = new Demande(u13, c3, "Bonjour, acceptez-vous les animaux ? Bonne journée !", true);
		Demande d7 = new Demande(u14, c1, "Hi ! I am a new student here and I am looking for somewhere to live ? Are u available ?", true);
		Demande d8 = new Demande(u14, c2, "Hi ! My name is Anna and I am new here !", true);
		Demande d9 = new Demande(u15, c3, "Salut, j'ai un chat est ce que cela est possible pour vous ?!", true);
		Demande d10 = new Demande(u15, c1, "Salut, j'ai un chat est ce que cela est possible pour vous ?!", true);
		Demande d11 = new Demande(u15, c2, "Salut, j'ai un chat est ce que cela est possible pour vous ?!", true);
		Demande d12 = new Demande(u16, c3, "Salut, je viens de commencer un nouveau travail ici. Seriez-vous au complet ?", true);
		
		demandeRepo.save(d1);
		demandeRepo.save(d2);
		demandeRepo.save(d3);
		demandeRepo.save(d4);
		demandeRepo.save(d5);
		demandeRepo.save(d6);
		demandeRepo.save(d7);
		demandeRepo.save(d8);
		demandeRepo.save(d9);
		demandeRepo.save(d10);
		demandeRepo.save(d11);
		demandeRepo.save(d12);


		
	}
	

	
	

}
