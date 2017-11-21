package jpa.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Transient;

import jpa.test.additionalclasses.EmbeddableKey2;
import jpa.test.entities.Columns;
import jpa.test.entities.EmbeddableEntity2;
import jpa.test.entities.Temporals;
import jpa.test.entities.Transients;
import jpa.test.entities.User2;
import util.Util;


public class TestTransients {

	public TestTransients() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        Transients c = new Transients(new Date(), new Date(), new Date());
        
		em.getTransaction().begin();
		em.persist(c);
		
		em.getTransaction().commit();
		em.clear();
		
		c = em.find(Transients.class, c.getId());
		Object o = em.createQuery("select count(c) from Transients c").getSingleResult();
		System.out.println("\nCount: "+((Long)o));
		System.out.println("Transients: "+c+"\n");
		
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestTransients();
	}

}
