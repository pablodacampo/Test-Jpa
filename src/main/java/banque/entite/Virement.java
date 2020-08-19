package banque.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Virement")
public class Virement extends Operation {

	private String beneficiaire;
	
	public Virement() {
		// TODO Auto-generated constructor stub
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
