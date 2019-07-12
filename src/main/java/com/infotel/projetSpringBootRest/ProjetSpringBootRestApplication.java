package com.infotel.projetSpringBootRest;//cest le lanceur

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infotel.projetSpringBootRest.dao.ProduitRepository;
import com.infotel.projetSpringBootRest.metier.Produit;

@SpringBootApplication//scanner ts les pacages ou ilya des annotations
public class ProjetSpringBootRestApplication {//va scanner tous les repertoires que se soit annotation jpa ou annotation controller

	public static void main(String[] args) {
		ApplicationContext ctx =                       //on a recupere AppContext //ctx je lutilise pour ajouter des produits 
				SpringApplication.run(ProjetSpringBootRestApplication.class, args);
		ProduitRepository dao =ctx.getBean(ProduitRepository.class);
		//dao.save(new Produit("Ipad", 50,850.0));
		dao.save(new Produit("Ordinateur", 70,600.0));
		dao.save(new Produit("souris", 100,20.0));
		dao.save(new Produit("clavier", 250,16.0));
		dao.save(new Produit("clé USB", 135,16.0));
		dao.save(new Produit("projecteur", 135,16.0));
		dao.save(new Produit("tel", 135,16.0));
		dao.save(new Produit("iphone 6", 135,16.0));
		dao.save(new Produit("samsung", 135,16.0));
		dao.save(new Produit("nokia", 135,16.0));
	
	System.out.println("----------------------------------");
	System.out.println("Liste Des Produits");
	List<Produit> produits =dao.findAll();
	for (Produit p :produits) {
		System.out.println(p);
	}
	}

}
