package jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.test.additionalclasses.EmbeddableKey2;
import jpa.test.entities.Columns;
import jpa.test.entities.EmbeddableEntity2;
import jpa.test.entities.User2;
import util.Util;


public class TestColumns {

	public TestColumns() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        Columns c = new Columns("Arek", "Garek");
        
		em.getTransaction().begin();
		em.persist(c);
		
//		Columns cc = em.find(Columns.class, 1);
//		System.out.println("Columns: "+cc);
//		cc.setSurname("Abc");
//		cc.setName("Abc");
//		em.persist(cc);
		
		em.getTransaction().commit();
		em.clear();
		
		c = em.find(Columns.class, c.getId());
		Object o = em.createQuery("select count(c) from Columns c").getSingleResult();
		System.out.println("\nCount: "+((Long)o));
		System.out.println("Columns: "+c+"\n");
		
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestColumns();
	}

}
