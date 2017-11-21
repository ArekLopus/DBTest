package jpa.test.concurency;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import jpa.test.entities.rs.Artist;
import jpa.test.rs.TestManyToManyBi;

public class TestVersioning {

	public TestVersioning() {
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
		System.out.println("Version: "+user.getVersion());
		
		em.getTransaction().begin();
		user.setName("Marek");
		em.getTransaction().commit();
		System.out.println("Version: "+user.getVersion());
		
		em.getTransaction().begin();
		//em.createQuery("delete from UserWithVersion a").executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		new TestVersioning();
	}
}
