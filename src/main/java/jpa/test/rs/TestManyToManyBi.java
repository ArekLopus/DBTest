package jpa.test.rs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.test.additionalclasses.EmbeddableKey2;
import jpa.test.entities.Columns;
import jpa.test.entities.EmbeddableEntity2;
import jpa.test.entities.User2;
import jpa.test.entities.User2XML;
import jpa.test.entities.rs.Address;
import jpa.test.entities.rs.Artist;
import jpa.test.entities.rs.CD;
import jpa.test.entities.rs.Customer;
import util.Util;


public class TestManyToManyBi {

	public TestManyToManyBi() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        Artist a1 = new Artist("Arek","Garek");
        CD cd1 = new CD("title2", 25f);
        CD cd2 = new CD("title1", 23f);
        CD cd3 = new CD("title4", 24f);
        CD cd4 = new CD("title3", 21f);
        a1.getAppearsOnCDs().add(cd1);
        a1.getAppearsOnCDs().add(cd2);
        a1.getAppearsOnCDs().add(cd3);
        a1.getAppearsOnCDs().add(cd4);
        
        cd1.getCreatedByArtists().add(a1);
        cd2.getCreatedByArtists().add(a1);
        
		em.getTransaction().begin();
		em.persist(cd1);
		em.persist(cd2);
		em.persist(cd3);
		em.persist(cd4);
		em.persist(cd2);
		em.persist(a1);
		
		em.getTransaction().commit();
		em.clear();
		
		a1 = em.find(Artist.class, a1.getId());
		cd1 = em.find(CD.class, cd1.getId());

		System.out.println("\nArtist: "+a1);
		System.out.println("CDs:   "+a1.getAppearsOnCDs()+"\n");
		
		System.out.println("CD: "+cd1);
		System.out.println("Ar:   "+cd1.getCreatedByArtists().get(0)+"\n");
		
//		em.getTransaction().begin();
//		em.remove(o);
//		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestManyToManyBi();
		//Persistence.generateSchema("DBTestPUEcl", null);
	}

}
