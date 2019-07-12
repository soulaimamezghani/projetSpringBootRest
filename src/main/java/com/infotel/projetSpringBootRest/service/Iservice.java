package com.infotel.projetSpringBootRest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.infotel.projetSpringBootRest.metier.Produit;

public interface Iservice {
 public Produit save(Produit p);
 public List<Produit> listProduit();
 public Produit getProduit  (Long id);//afficher un produit a partir de son id
 public boolean delete(Long id);
 public Produit update (Long id,Produit p);//modifier un produit a partir de son id et on donne un nouveau produit
 public Page<Produit> listProductsPagination(int page,int nombre);
 
 public List<Produit> findByNomProduit (String nomProduit);//cest du spring data
 public Page<Produit>  findByNomProduit(String nomProduit,int page,int nombre);
 public List<Produit> rechercheParMotCle(String mc);
 public Page<Produit> rechercheParMotCle(String mc,int page,int nombre);
 public List<Produit> prixComprisEntre(double prix1,double prix2);
 //public Page<Produit> prixComprisEntre(double prix1,double prix2,Pageable pageable);
public Page<Produit> prixComprisEntre(double prix1,double prix2,int page,int nombre);
 
}
