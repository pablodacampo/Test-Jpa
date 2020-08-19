package banque.entite;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("V")
public class AssuranceVie extends Compte {

	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	private Double taux;
	
	public AssuranceVie() {
		// TODO Auto-generated constructor stub
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	

}
