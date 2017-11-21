package jpa.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Transient;

import jpa.test.additionalclasses.EmbeddableAddress;
import jpa.test.additionalclasses.EmbeddableKey2;
import jpa.test.additionalclasses.EnumTypeMy;
import jpa.test.entities.Columns;
import jpa.test.entities.EmbeddableEntity2;
import jpa.test.entities.EmbeddedFieldEntity;
import jpa.test.entities.Enumerates;
import jpa.test.entities.Temporals;
import jpa.test.entities.Transients;
import jpa.test.entities.User2;
import jpa.test.entities.User2XML;
import util.Util;


public class TestEmbeddedFieldEntity {

	public TestEmbeddedFieldEntity() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        EmbeddedFieldEntity o = new EmbeddedFieldEntity("Arek", "Garek", new EmbeddableAddress("Poznańska", "Warsaw"));
        
		em.getTransaction().begin();
		em.persist(o);
		
		em.getTransaction().commit();
		em.clear();
		
		o = em.find(EmbeddedFieldEntity.class, o.getId());
		Object c = em.createQuery("select count(o) from EmbeddedFieldEntity o").getSingleResult();
		System.out.println("\nCount: "+((Long)c));
		System.out.println("EmbeddedFieldEntity: "+o+"\n");
		
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestEmbeddedFieldEntity();
	}

}
