package jpa.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Transient;

import jpa.test.additionalclasses.EmbeddableKey2;
import jpa.test.additionalclasses.EnumTypeMy;
import jpa.test.entities.Columns;
import jpa.test.entities.EmbeddableEntity2;
import jpa.test.entities.Enumerates;
import jpa.test.entities.Temporals;
import jpa.test.entities.Transients;
import jpa.test.entities.User2;
import util.Util;


public class TestEnumerates {

	public TestEnumerates() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        Enumerates c = new Enumerates(EnumTypeMy.MEDIUM);
        
		em.getTransaction().begin();
		em.persist(c);
		
		em.getTransaction().commit();
		em.clear();
		
		c = em.find(Enumerates.class, c.getId());
		Object o = em.createQuery("select count(c) from Enumerates c").getSingleResult();
		System.out.println("\nCount: "+((Long)o));
		System.out.println("Enumerates: "+c+"\n");
		
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestEnumerates();
	}

}
