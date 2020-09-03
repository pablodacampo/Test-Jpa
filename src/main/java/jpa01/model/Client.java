package jpa01.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity Client 
 * Li� avec Emprunt (par ma cl� �trang�re ID_client qui est la colonne SQL de la 
 * table Emprunt cette colonne va devenir par un attribut clientE par le lien
 * @ManyToOne impl�ment� dans l'entity Emprunt
 */

@Entity
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nom",length = 50,insertable = false)
	private String nom;
	
	@Column(name="prenom",length = 50,insertable = false)
	private String prenom;
	
	@OneToMany(mappedBy = "clientE")
	private List<Emprunt> listeEmprunt;
	
	public Client() {
		// TODO Auto-generated constructor stub
		this.listeEmprunt =  new ArrayList<Emprunt>();
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public List<Emprunt> getListeEmprunt() {
		return listeEmprunt;
	}


	public void setListeEmprunt(List<Emprunt> listeEmprunt) {
		this.listeEmprunt = listeEmprunt;
	}


	

}
