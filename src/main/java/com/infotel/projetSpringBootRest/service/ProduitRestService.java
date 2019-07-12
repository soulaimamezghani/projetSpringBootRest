package com.infotel.projetSpringBootRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.projetSpringBootRest.dao.ProduitRepository;
import com.infotel.projetSpringBootRest.metier.Produit;

@CrossOrigin("*") // pour que angular aura un acces au donnes//rendre le web service accessible au
					// front
@RestController // pour dire que cest du ws rest
public class ProduitRestService implements Iservice {// on va faire ws depuis spring//on va faire crud
	@Autowired
	private ProduitRepository produitRepository;// produitRepository est ma dao meme chose

	@RequestMapping(value = "/produits", method = RequestMethod.POST) // quand jappelle cette methode cest pour //
																		// enregistrer
	@Override
	public Produit save(@RequestBody Produit p) {// lorsque cest une classe on fait RequestBody(va chercher dans
													// formulaire)//@requestparam si des attributs types primitifs
		return produitRepository.save(p);
		// http://localhost:8080/produits
	}

	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	@Override
	public List<Produit> listProduit() {
		return produitRepository.findAll();
		// http://localhost:8080/produits
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.GET)
	@Override
	public Produit getProduit(@PathVariable Long id) {
		return produitRepository.getOne(id);
		// http://localhost:8080/produits/356
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.DELETE)
	@Override
	public boolean delete(@PathVariable Long id) {
		produitRepository.deleteById(id);
		return true;
		// http://localhost:8080/produits/356
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.PUT)
	@Override
	public Produit update(@PathVariable Long id, @RequestBody Produit p) {

		p.setIdProduit(id);
		return produitRepository.save(p);
		// http://localhost:8080/produits/300
		// {"nomProduit":"machinealaver","quantite":12,"prix":58.03}
	}

	@RequestMapping(value = "/produitsPage", method = RequestMethod.GET)
	@Override
	public Page<Produit> listProductsPagination(@RequestParam(name = "page") int page,
			@RequestParam(name = "nombre") int nombre) {

		return produitRepository.findAll(PageRequest.of(page, nombre));// je prends findAll(pageable);//passer page puis
																		// nombre

		// http://localhost:8080/produitsPage?page=25&nombre=14
	}

	@RequestMapping(value = "/produitsParNom/{nomProduit}", method = RequestMethod.GET) // variable est {nomProduit}
	@Override
	public List<Produit> findByNomProduit(@PathVariable String nomProduit) {

		return produitRepository.findByNomProduit(nomProduit);
		// http://localhost:8080/produitsParNom/souris
	}

	@RequestMapping(value = "/produitsParNomPagination/{nomProduit}", method = RequestMethod.GET)
	@Override
	public Page<Produit> findByNomProduit(@PathVariable String nomProduit, // pageable englobe les pages et nombre
			@RequestParam(name = "page") int page, @RequestParam(name = "nombre") int nombre) {

		return produitRepository.findByNomProduit(nomProduit, PageRequest.of(page, nombre));
		// http://localhost:8080/produitsParNomPagination/souris?page=2&nombre=4
		// http://localhost:8080//produitsParNomPagination/souris?page=3&nombre=10
	}

	@RequestMapping(value = "/produitsParMotCle/{mc}", method = RequestMethod.GET)
	@Override
	public List<Produit> rechercheParMotCle(@PathVariable String mc) {

		return produitRepository.rechercheParMotCle("%" + mc + "%");
		// http://localhost:8080/produitsParMotCle/souris
	}

	@RequestMapping(value = "/produitsParMotClePagination/{mc}", method = RequestMethod.GET)
	@Override
	public Page<Produit> rechercheParMotCle(@PathVariable String mc, @RequestParam(name = "page") int page,
			@RequestParam(name = "nombre") int nombre) {

		return produitRepository.rechercheParMotCle("%" + mc + "%", PageRequest.of(page, nombre));
		// http://localhost:8080/produitsParMotClePagination/souris?page=4&nombre=3
	}

	@RequestMapping(value = "/produitsCompris/{prix1}/{prix2}", method = RequestMethod.GET)
	@Override
	public List<Produit> prixComprisEntre(@PathVariable double prix1, @PathVariable double prix2) {

		return produitRepository.prixComprisEntre(prix1, prix2);
	}

	@RequestMapping(value = "/produitsComprisPaging/{prix1}/{prix2}", method = RequestMethod.GET)
	@Override
	public Page<Produit> prixComprisEntre(@PathVariable double prix1, @PathVariable double prix2,
			@RequestParam(name = "page") int page, @RequestParam(name = "nombre") int nombre) {

		return produitRepository.prixComprisEntre(prix1, prix2, PageRequest.of(page, nombre));

	}

}
