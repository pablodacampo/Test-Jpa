package jpa01;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

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
	public void listeLivresWhere( ) {
		EntityManager em = factory.createEntityManager();
		
		if(em != null ) {
			String query = "SELECT l FROM Livre l WHERE l.id >= 3";
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
		l.getAuteur().setAuteur("Victor hugo");
		l.getAuteur().setTitre("Les Mis�rables");
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
		l.getAuteur().setTitre("Les Orientales");
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
	
	
	
}
