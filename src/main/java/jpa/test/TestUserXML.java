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
import jpa.test.entities.User2XML;
import util.Util;


public class TestUserXML {

	public TestUserXML() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        User2XML o = new User2XML("Arek", "Garek");
        
		em.getTransaction().begin();
		em.persist(o);
		
		em.getTransaction().commit();
		em.clear();
		
		o = em.find(User2XML.class, o.getId());
		Object c = em.createQuery("select count(o) from User2XML o").getSingleResult();
		System.out.println("\nCount: "+((Long)c));
		System.out.println("User2XML: "+o+"\n");
		
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestUserXML();
	}

}
