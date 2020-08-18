package jpa01.modeleleves;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "t_eleve")
public class Eleve extends Personne {
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "classe")
	private Classe classe;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_naissance")
	private Date datenaissance;
	
	private String adresse;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "enum('HOMME', 'FEMME')")
	private Genre sexe;

	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Genre getSexe() {
		return sexe;
	}

	public void setSexe(Genre sexe) {
		this.sexe = sexe;
	}
	
	

}
