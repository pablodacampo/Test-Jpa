package banque.entite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("A")
public class LivretA extends Compte {

	private Double taux;
	
	public LivretA() {
		// TODO Auto-generated constructor stub
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
