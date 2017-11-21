package jpa.test.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa.test.entities.rs.Artist;


public class TestNativeQuery {

	public TestNativeQuery() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
		EntityManager em = emf.createEntityManager();
		        
		em.getTransaction().begin();
		for (int i=1; i<21; i++) {
			Artist a = new Artist("Arek"+i,"Garek"+i);
			em.persist(a);
		}
		em.getTransaction().commit();
		
		List<Artist> artists = em.createNativeQuery("SELECT * FROM artist", Artist.class).getResultList();
		System.out.println("List size: "+artists.size());
		
		em.getTransaction().begin();
		em.createNativeQuery("delete from artist").executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		new TestNativeQuery();
	}
}
