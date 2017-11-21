package jpa.test.cache;

import java.util.List;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa.test.entities.rs.Artist;


public class TestCacheAfterDisconect {
	
	public TestCacheAfterDisconect() {
		
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Artist a = new Artist("Arek","Garek");
		em.persist(a);
		em.getTransaction().commit();
		
		List<Artist> artists = em.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
		System.out.println("\nList size: "+artists.size());
		
		em.getTransaction().begin();
		Cache cache = emf.getCache();			
		System.out.println("Atrist exists in cache: "+cache.contains(Artist.class, a.getId()));
		//em.createQuery("delete from Artist").executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		em = emf.createEntityManager();
		cache = emf.getCache();
		System.out.println("Atrist exists in cache: "+cache.contains(Artist.class, a.getId()));
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		new TestCacheAfterDisconect();
	}
}
