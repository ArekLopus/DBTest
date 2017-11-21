package jpa.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.test.additionalclasses.EmbeddableKey;
import jpa.test.additionalclasses.EmbeddableKey2;
import jpa.test.entities.ElementCollections;
import jpa.test.entities.EmbeddableEntity;
import jpa.test.entities.EmbeddableEntity2;
import util.Util;


public class TestElementCollections {

	public TestElementCollections() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        ElementCollections ec = new ElementCollections();
        ec.setSurname("Surname1");
        List<String> sl = ec.getNameList();
        sl.add("Name11");
        sl.add("Name12");
        sl.add("Name13");
        
//        ElementCollections ec1 = new ElementCollections();
//        ec1.setSurname("Surname2");
//        List<String> sl1 = ec1.getNameList();
//        sl1.add("Name21");
//        sl1.add("Name22");
//        sl1.add("Name23");
        
		em.getTransaction().begin();
		em.persist(ec);
//		em.persist(ec1);
		em.getTransaction().commit();
		
		em.clear();
		
		System.out.println("\nDefault FetchType:	javax.persistence.FetchType.LAZY");
		ec = em.find(ElementCollections.class, ec.getId());
		System.out.println("ElementCollections: "+ ec);
		
		Object o = em.createQuery("select count(e) from ElementCollections e", ElementCollections.class).getSingleResult();
		System.out.println("Count: "+((Long)o));
		
		em.getTransaction().begin();
		em.remove(ec);
		em.getTransaction().commit();
		 
		System.out.println("!st name: "+ec.getNameList().get(0)+"\n");
		
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestElementCollections();
	}

}
