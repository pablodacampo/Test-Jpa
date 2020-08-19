package banque.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private double solde;
	
	@ManyToMany
	@JoinTable(name = "Comptes_clients",
	joinColumns = @JoinColumn(name="ID_Compte"),
	inverseJoinColumns=@JoinColumn(name="Id_client"))
	private List<ClientB> listeClient = new ArrayList<ClientB>();
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<ClientB> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<ClientB> listeClient) {
		this.listeClient = listeClient;
	}

}
