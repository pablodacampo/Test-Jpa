package jpa01.model;

import javax.persistence.Embeddable;

@Embeddable
public class Auteur {
	/**
	 * Respecter le nom et le type des colonnes
	 * il faut que ce soit en coh�rence avec la BDD
	 * physique
	 */
	private String titre;
	private String auteur;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
}
