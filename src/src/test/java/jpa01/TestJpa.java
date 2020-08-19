package jpa01;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import jpa01.model.Client;
import jpa01.model.Emprunt;
import jpa01.model.Livre;


public class TestJpa {
	private EntityManagerFactory factory = null;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
	}
	@Test
	public void findLivre() {
		EntityManager em = factory.createEntityManager();
		
		if(em != null ) {
			Livre livre1 = em.find(Livre.class,1);
			System.out.println(livre1);
		}
		em.close();
		factory.close();
	}
	@Test
	public void listeLivres( ) {
		EntityManager em = factory.createEntityManager();
		
		if(em != null ) {
			String query = "SELECT l FROM Livre l";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for(Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();
	}
	@Test
	public void listeLivresW( ) {
		EntityManager em = factory.createEntityManager();
		
		if(em != null ) {
			String query = "SELECT l FROM Livre l where l.id >= 3";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for(Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();
	}

	@Test
	public void insertLivre( ) {
		EntityManager em = factory.createEntityManager();
		Livre l = new Livre();
		l.setId(6);
		l.getAuteurEmbedd().setAuteur("Victor hugo");
		l.getAuteurEmbedd().setTitre("Les Misérables");
		//J'ouvre une transaction
		em.getTransaction().begin();
		//j'ajoute dans la BDD mon nouveau Livre
		em.persist(l);
		//Je commite et ferme la transaction
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void updateLivre( ) {
		EntityManager em = factory.createEntityManager();
		//J'ouvre une transaction
		em.getTransaction().begin();
		//Find transcient : transactionnel
		Livre l = em.find(Livre.class,5);
		l.getAuteurEmbedd().setTitre("Les Orientales");
		//j'ajoute dans la BDD mon nouveau Livre
		em.merge(l);
		//Je commite et ferme la transaction
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	@Test
	public void deleteLivre( ) {
		EntityManager em = factory.createEntityManager();
		//J'ouvre une transaction
		em.getTransaction().begin();
		//Find transcient : transactionnel
		Livre l = em.find(Livre.class,6);
		//j'ajoute dans la BDD mon nouveau Livre
		em.remove(l);
		//Je commite et ferme la transaction
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	/**
	 * Réalisez une requête qui permet d’extraire 
	 * un emprunt et tous ses livres associés.
	 */
	@Test
	public void empuntListeLivres()
	{
		EntityManager em = factory.createEntityManager();
		
		if(em != null ) {
			String query = "SELECT e FROM Emprunt e where e.id = 2";
			TypedQuery<Emprunt> q = em.createQuery(query, Emprunt.class);
			for(Emprunt e : q.getResultList()) {
				System.out.println("Emprunt :" + e.getId() );
				for(Livre l : e.getListeLivreE())
				{
					System.out.println("Livre Emprunté : " +l);
				}
			}
		}
		em.close();
		factory.close();
	}
	/**
	 * Réalisez une requête qui permet d’extraire
	 *  tous les emprunts d’un client donné.
	 */
	@Test
	public void clientListeEmprunts()
	{
		EntityManager em = factory.createEntityManager();
		
		if(em != null ) {
			String query = "SELECT c FROM Client c where c.id = 2";
			TypedQuery<Client> q = em.createQuery(query, Client.class);
			for(Client c : q.getResultList()) {
				System.out.println(c);
				for(Emprunt e : c.getListeEmprunt())
				{
					System.out.println("Emprunt : "+e);
				}
			}
		}
		em.close();
		factory.close();
	}
	
}
