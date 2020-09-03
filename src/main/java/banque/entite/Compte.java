package banque.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double solde;
	
	
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

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public List<ClientB> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<ClientB> listeClient) {
		this.listeClient = listeClient;
	}

}
