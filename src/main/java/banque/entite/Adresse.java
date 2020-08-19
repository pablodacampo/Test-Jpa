package banque.entite;

import javax.persistence.Embeddable;

/**
 * Sous ensemble pour les Entity
 * @author avosclics
 *
 */
@Embeddable
public class Adresse {

	private int numero;
	private String rue;
	private int codepostal;
	private String ville;
	
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
