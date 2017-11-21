package jpa.test.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.test.entities.rs.Artist;
import jpa.test.rs.TestManyToManyBi;

public class TestPagination {

	public TestPagination() {
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
		
		em.getTransaction().begin();
		List<Artist> ar = em.createNamedQuery(Artist.FIND_ALL).setFirstResult(0).setMaxResults(10).getResultList();
		System.out.println("List size: "+ar.size());
		ar.stream().forEach(e -> System.out.print(e.getId()+", "));
		System.out.println("");
		ar = em.createQuery("select a from Artist a").setFirstResult(10).setMaxResults(10).getResultList();
		System.out.println("List size: "+ar.size());
		ar.stream().forEach(e -> System.out.print(e.getId()+", "));
		System.out.println("");
		em.getTransaction().commit();
		
		
		em.getTransaction().begin();
		em.createQuery("delete from Artist a").executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		new TestPagination();
	}
}
