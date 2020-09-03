package jpa01.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * Entity Emprunt qui a une cl� foreignkey mat�rialis�e par 
 * @ManyToOne
 * @JoinColumn(name="ID_CLIENT",nullable = false)
 * private Client clientE;
 * 
 * Je vais utiliser @JoinTable pour r�cup�rer les livres Emprunt�s
 * dans la table "relation" COMPO
 * @ManyToMany
 * @JoinTable(name = "COMPO",
 * joinColumns = @JoinColumn(name="ID_EMP"),
 * inverseJoinColumns=@JoinColumn(name="Id_LIV"))
 * private List<Livre> listeLivreE;
 */

@Entity
@Table(name="emprunt")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_DEBUT")
	private Date datedebut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_FIN")
	private Date datefin;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT",nullable = false)
	private Client clientE; 
	
	@ManyToMany
	@JoinTable(name = "COMPO",
	joinColumns = @JoinColumn(name="ID_EMP"),
	inverseJoinColumns=@JoinColumn(name="Id_LIV"))
	private List<Livre> listeLivreE;
	
	
	public Emprunt() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDatedebut() {
		return datedebut;
	}


	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}


	public Date getDatefin() {
		return datefin;
	}


	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}


	public Client getClientE() {
		return clientE;
	}


	public void setClientE(Client clientE) {
		this.clientE = clientE;
	}


	public List<Livre> getListeLivreE() {
		return listeLivreE;
	}


	public void setListeLivreE(List<Livre> listeLivreE) {
		this.listeLivreE = listeLivreE;
	}


	@Override
	public String toString() {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		return "Emprunt [id=" + id + ", datedebut=" + 
				formater.format(datedebut) + 
				", datefin=" + formater.format(datefin) + "]";
	}

}
