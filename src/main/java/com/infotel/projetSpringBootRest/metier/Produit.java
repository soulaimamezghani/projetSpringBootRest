package com.infotel.projetSpringBootRest.metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


////import lombok.Data;
////@Data//elle genere les getters et setters
//@Getter
//@Setter
////@RequiredArgsConstructor//pour generer des constructeurs avec les arguments
@NoArgsConstructor//arguments sans argumrnt
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode//Equals =permet comparer les objets  /Hashcode=generer un code unique pour les objets
@Data
@Entity //annotation de jpa
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produit implements Serializable{
	@Id// annotation de jpa
	@GeneratedValue(strategy=GenerationType.IDENTITY)// annotation de jpa
	private long idProduit;
	//@Column(nullable=false)//cette column pour que le constructeur soit avec lattribut nomProduit et du coup on fait annotationRequiredArgsConstructor
	private @NonNull String nomProduit;

	private int quantite;

	private  double prix;

	public Produit(@NonNull String nomProduit, int quantite, double prix) {
		super();
		this.nomProduit = nomProduit;
		this.quantite = quantite;
		this.prix = prix;
	}

	public Produit(long idProduit, @NonNull String nomProduit, int quantite, double prix) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.quantite = quantite;
		this.prix = prix;
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Produit() {
		super();
	}

	


	
	

}
