package jpa01;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import jpa01.modeleleves.*;



public class TestEleveJpa {
	private EntityManagerFactory factory = null;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("base_eleve");
	}
	@Test
	public void findClasse() {
		EntityManager em = factory.createEntityManager();
		
		if(em != null ) {
			Classe classe1 = em.find(Classe.class,1);
			if(classe1 != null) System.out.println(classe1.getNom());
		}
		em.close();
		factory.close();
	}
	@Test
	public void listeClasseNomprof( ) {
		EntityManager em = factory.createEntityManager();
		
		if(em != null ) {
			String query = "SELECT cl FROM Classe cl";
			TypedQuery<Classe> q = em.createQuery(query, Classe.class);
			for(Classe l : q.getResultList()) {
				System.out.println("Nom de la classe "+ 
			l.getNom() + "\n\t Nom du prof : " +l.getProf().getNom());
			}
		}
		em.close();
		factory.close();
	}

	@Test
	public void listeNomprofClasses( ) {
		EntityManager em = factory.createEntityManager();
		if(em != null ) {
			String query = "SELECT prof FROM Professeur prof";
			TypedQuery<Professeur> q = em.createQuery(query, Professeur.class);
			for(Professeur prof : q.getResultList()) {
				System.out.println("Nom du prof "+prof.getNom());
				for(Classe classe : prof.getClasses()) {
					System.out.println("Classe : "+classe.getNom());
				}
			}
		}
		em.close();
		factory.close();
	}
	
	
}
