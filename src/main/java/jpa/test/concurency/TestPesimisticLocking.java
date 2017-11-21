package jpa.test.concurency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import jpa.test.entities.rs.Artist;
import jpa.test.rs.TestManyToManyBi;

public class TestPesimisticLocking {

	public TestPesimisticLocking() {
		//Switch libs in POM!!!!!
		Map<String, String> map = new HashMap<>();
		map.put("javax.persistence.lock.timeout", "10000");	//Nie działa na H2, std 2000ms
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl", map);
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Artist artist = new Artist("Arek","Garek");
		em.persist(artist);
		em.getTransaction().commit();
		
		
		List<Artist> artists = em.createQuery("select a from Artist a", Artist.class).getResultList();
		System.out.println("List size: "+artists.size());
		
		
		new Thread(() -> {
			try {
				EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("DBTestPUEcl");
				EntityManager em1 = emf1.createEntityManager();
				em1.getTransaction().begin();
				Artist ar = em1.find(Artist.class, artist.getId(), LockModeType.PESSIMISTIC_WRITE);
				ar.setName("Małpa");
				Thread.sleep(3000);
				em1.getTransaction().commit();
				em1.close();
				emf1.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("DBTestPUEcl");
				//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
				EntityManager em2 = emf2.createEntityManager();
				em2.getTransaction().begin();
				Artist ar = em2.find(Artist.class, artist.getId(), LockModeType.PESSIMISTIC_WRITE);
				ar.setName("Dupa");
				Thread.sleep(3000);
				em2.getTransaction().commit();
				em2.close();
				emf2.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}).start();
		
		
		artists.stream().forEach(e -> System.out.print(e.getId()+", "));
		System.out.println("");
		
		
		
		em.getTransaction().begin();
		//em.createQuery("delete from Artist a").executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		new TestPesimisticLocking();
	}
}
