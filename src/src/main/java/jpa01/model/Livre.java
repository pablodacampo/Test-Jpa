package jpa01.model;


import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {

	@Id
	private int id;
	
	@Embedded
	private Auteur auteurEmbedd;
	
	@OneToMany(mappedBy = "listeLivreE")
	private List<Emprunt> listeEmpuntL;
	
	

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
		return "Livre [id=" + id + 
				"auteur:"+this.getAuteurEmbedd().getAuteur() +
				"titre:"+this.getAuteurEmbedd().getTitre() +"]";
	}


	public Auteur getAuteurEmbedd() {
		return auteurEmbedd;
	}


	public void setAuteurEmbedd(Auteur auteurEmbedd) {
		this.auteurEmbedd = auteurEmbedd;
	}


	public List<Emprunt> getListeEmpuntL() {
		return listeEmpuntL;
	}


	public void setListeEmpuntL(List<Emprunt> listeEmpuntL) {
		this.listeEmpuntL = listeEmpuntL;
	}

	
}
