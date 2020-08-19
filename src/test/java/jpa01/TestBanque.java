package jpa01;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import banque.entite.*;


public class TestBanque {
private EntityManagerFactory factory = null;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("banque");
	}
	
	@Test
	public void insertion() {
		EntityManager em = factory.createEntityManager();
		//J'ouvre une transaction
		em.getTransaction().begin();
		//Find transcient : transactionnel
		ClientB c = new ClientB();
		Banque b = new Banque();
		Adresse a =  new Adresse();
		a.setCodepostal(44000);
		a.setNumero(10);
		a.setRue("rue principale");
		a.setVille("Nantes");
		b.setNom("BANQUE DIGINAMIC");
		em.persist(b);
		c.setDateNaissance(new Date());
		c.setBanque(b);
		c.setAdresse(a);
		em.persist(c);
		
		Compte cpte = new Compte();
		cpte.setSolde(150);
		cpte.getListeClient().add(c);
		
		em.persist(cpte);
		
		//Je commite et ferme la transaction
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
