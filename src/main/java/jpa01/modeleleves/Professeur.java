package jpa01.modeleleves;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "t_prof")
public class Professeur extends Personne {
	
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_naissance")
	private Date datenaissance;
	
	@OneToMany(mappedBy = "profClasse")
	private List<Classe> classes;
	
	
	
	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	private String adresse;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "enum('HOMME', 'FEMME')")
	private Genre sexe;

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
