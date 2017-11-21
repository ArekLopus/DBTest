package jpa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.test.additionalclasses.EmbeddableKey;
import jpa.test.additionalclasses.EmbeddableKey2;
import jpa.test.entities.ElementCollections;
import jpa.test.entities.ElementCollectionsMap;
import jpa.test.entities.EmbeddableEntity;
import jpa.test.entities.EmbeddableEntity2;
import util.Util;


public class TestElementCollectionsMap {

	public TestElementCollectionsMap() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        ElementCollectionsMap ec = new ElementCollectionsMap();
        ec.setSurname("Surname1");
        Map<Integer, String> sl = ec.getTracks();
        sl.put(1,"Track11");
        sl.put(2,"Track12");
        sl.put(3,"Track13");
        
//        ElementCollectionsMap ec1 = new ElementCollectionsMap();
//        ec1.setSurname("Surname2");
//        Map<Integer, String> sl1 = ec1.getTracks();
//        sl1.put(1,"Track21");
//        sl1.put(2,"Track22");
//        sl1.put(3,"Track23");
        
		em.getTransaction().begin();
		em.persist(ec);
		//em.persist(ec1);
		em.getTransaction().commit();
		
		em.clear();
		
		System.out.println("\nDefault FetchType:	javax.persistence.FetchType.LAZY");
		ec = em.find(ElementCollectionsMap.class, ec.getId());
		System.out.println("ElementCollectionsMap: "+ ec);
		
		Object o = em.createQuery("select count(e) from ElementCollectionsMap e", ElementCollections.class).getSingleResult();
		System.out.println("Count: "+((Long)o)+"\n");
		
		em.getTransaction().begin();
		em.remove(ec);
		em.getTransaction().commit();
		 
		//System.out.println("!st name: "+ec.getTracks()+"\n");
		
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestElementCollectionsMap();
	}

}
