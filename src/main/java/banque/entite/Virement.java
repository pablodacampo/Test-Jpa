package banque.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Virement")
public class Virement extends Operation {

	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
