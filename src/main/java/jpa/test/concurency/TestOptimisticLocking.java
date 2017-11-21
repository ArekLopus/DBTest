package jpa.test.concurency;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import jpa.test.entities.rs.Artist;
import jpa.test.rs.TestManyToManyBi;

public class TestOptimisticLocking {

	public TestOptimisticLocking() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		UserWithVersion user = new UserWithVersion("Arek","Garek");
		em.persist(user);
		em.getTransaction().commit();
		
		
		List<UserWithVersion> users = em.createQuery("select a from UserWithVersion a", UserWithVersion.class).getResultList();
		System.out.println("List size: "+users.size());
		
		
		new Thread(() -> {
			try {
				EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("DBTestPUEcl");
				EntityManager em1 = emf1.createEntityManager();
				em1.getTransaction().begin();
				UserWithVersion ar = em1.find(UserWithVersion.class, user.getId(), LockModeType.OPTIMISTIC);
				ar.setName("Małpa");
				Thread.sleep(4000);
				em1.getTransaction().commit();
				em1.close();
				emf1.close();
			} catch (Exception e1) {
				//e1.printStackTrace();
				persistUser(user);
			}
		}).start();

		new Thread(() -> {
			try {
				EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("DBTestPUEcl");
				//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
				EntityManager em2 = emf2.createEntityManager();
				em2.getTransaction().begin();
				UserWithVersion ar = em2.find(UserWithVersion.class, user.getId(), LockModeType.OPTIMISTIC);
				ar.setName("Dupa");
				Thread.sleep(5000);
				em2.getTransaction().commit();
				em2.close();
				emf2.close();
			} catch (Exception e1) {
				//e1.printStackTrace();
				persistUser(user);
			}
		}).start();
		
		
		users.stream().forEach(e -> System.out.print(e.getId()+", "));
		System.out.println("");
		
		
		
		em.getTransaction().begin();
		//em.createQuery("delete from Artist a").executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	private void persistUser(UserWithVersion user) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			UserWithVersion ar = em.find(UserWithVersion.class, user.getId(), LockModeType.OPTIMISTIC);
			ar.setName("Dupa");
			Thread.sleep(5000);
			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TestOptimisticLocking();
	}
}
