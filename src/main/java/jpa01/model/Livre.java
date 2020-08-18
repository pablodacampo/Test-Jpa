package jpa01.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {

	@Id
	private int id;
	
	@Embedded
	private Auteur auteurEmbedd;
	
	
	public Auteur getAuteur() {
		return auteurEmbedd;
	}


	public void setAuteur(Auteur auteur) {
		this.auteurEmbedd = auteur;
	}


	public Livre() {
		// TODO Auto-generated constructor stub*
		this.auteurEmbedd = new Auteur();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Livre [id=" + id +  "]";
	}

	
}
