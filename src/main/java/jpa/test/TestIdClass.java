package jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.test.additionalclasses.EmbeddableKey;
import jpa.test.additionalclasses.EmbeddableKey2;
import jpa.test.entities.EmbeddableEntity;
import jpa.test.entities.EmbeddableEntity2;
import util.Util;


public class TestIdClass {

	public TestIdClass() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
		
        EmbeddableKey2 key = new EmbeddableKey2("en", "partOne");
        EmbeddableEntity2 ee = new EmbeddableEntity2("en", "partOne", "Arek", "Garek");
        
		em.getTransaction().begin();
		em.persist(ee);
		em.getTransaction().commit();
		
		em.clear();
		
		ee = em.find(EmbeddableEntity2.class, key);
		System.out.println("\nEmbeddableEntity2: "+ ee + "\n");

		List<EmbeddableEntity2> list = em.createQuery("select e from EmbeddableEntity2 e where e.lang='en' ", EmbeddableEntity2.class).getResultList();
		System.out.println("EmbeddableEntity2: "+ list.get(0) + "\n");
		
		em.getTransaction().begin();
		em.remove(ee);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestIdClass();
	}

}
