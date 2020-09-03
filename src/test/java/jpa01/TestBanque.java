package jpa01;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import banque.entite.Adresse;
import banque.entite.AssuranceVie;
import banque.entite.Banque;
import banque.entite.ClientB;
import banque.entite.LivretA;


public class TestBanque {
private EntityManagerFactory factory = null;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("banque");
	}
	
	@SuppressWarnings("deprecation")
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
		
		LivretA cpte = new LivretA();
		cpte.setSolde(new Double(150));
		cpte.setTaux(1.25);
		cpte.getListeClient().add(c);
		
		em.persist(cpte);
		
		ClientB c2 = new ClientB();
		Adresse a2 =  new Adresse();
		a2.setCodepostal(24000);
		a2.setNumero(20);
		a2.setRue("rue principale");
		a2.setVille("Perigueux");
		em.persist(b);
		c2.setDateNaissance(new Date());
		c2.setBanque(b);
		c2.setAdresse(a);
		em.persist(c2);
		
		AssuranceVie cpte2 = new AssuranceVie();
		cpte2.setSolde(new Double(1500));
		cpte2.setTaux(1.25);
		cpte2.setDateFin(new Date());
		cpte2.getListeClient().add(c2);
		
		em.persist(cpte2);
		
		//Je commite et ferme la transaction
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
