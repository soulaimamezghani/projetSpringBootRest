package com.infotel.projetSpringBootRest.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infotel.projetSpringBootRest.metier.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {// notre dao est terminée

	public List<Produit> findByNomProduit(String nomProduit);// on met pas dannotation car nomProduit est dependant il
																// est recoonnu comm attribu

	public Page<Produit> findByNomProduit(String nomProduit, Pageable pageable);

	@Query("select p from Produit p where p.nomProduit like :x")
	public List<Produit> rechercheParMotCle(@Param("x") String mc);

	@Query("select p from Produit p where p.nomProduit like %:x%")// ou ("select p from Produit p where p.nomProduit like :x")
	public Page<Produit> rechercheParMotCle(@Param("x") String mc, Pageable pageable);

	@Query("select p from Produit p where p.prix > :x and p.prix < :y")
	public List<Produit> prixComprisEntre(@Param("x") double prix1, @Param("y") double prix2);

	@Query("select p from Produit p where p.prix > :x and p.prix < :y")
	public Page<Produit> prixComprisEntre(@Param("x") double prix1, @Param("y") double prix2, Pageable pageable);

}
