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


public class TestCriteria {

	public TestCriteria() {
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
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Artist> criteriaQuery = builder.createQuery(Artist.class);
		Root<Artist> c = criteriaQuery.from(Artist.class);
		//criteriaQuery.select(c).where(builder.equal(c.get("name"), "Arek1"));
		criteriaQuery.select(c).where(builder.like(c.get("name"), "Arek%"));
		Query query = em.createQuery(criteriaQuery);
		List<Artist> artists = query.getResultList();
		System.out.println("List size: "+artists.size());
		
		em.getTransaction().begin();
		em.createQuery("delete from Artist a").executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		new TestCriteria();
	}
}
