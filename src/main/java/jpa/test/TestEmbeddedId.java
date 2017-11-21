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


public class TestEmbeddedId {

	public TestEmbeddedId() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
		
        EmbeddableKey key = new EmbeddableKey("en","partOne");
        EmbeddableEntity ee = new EmbeddableEntity(key, "Arek", "Garek");
        
		em.getTransaction().begin();
		em.persist(ee);
		em.getTransaction().commit();
		
		em.clear();
		
		ee = em.find(EmbeddableEntity.class, key);
		System.out.println("\nEmbeddableEntity: "+ ee + "\n");

		List<EmbeddableEntity> list = em.createQuery("select e from EmbeddableEntity e where e.key.lang='en' ", EmbeddableEntity.class).getResultList();
		System.out.println("EmbeddableEntity: "+ list.get(0) + "\n");
		
		em.getTransaction().begin();
		em.remove(ee);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestEmbeddedId();
	}

}
