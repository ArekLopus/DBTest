package jpa.test.listener;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import jpa.test.entities.rs.Artist;
import jpa.test.rs.TestManyToManyBi;

public class TestListenersOrder {

	public TestListenersOrder() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Admin admin = new Admin("Arek","Garek","Admin");
		em.persist(admin);
		em.getTransaction().commit();
		
		List<Admin> admins = em.createQuery("select a from Admin a", Admin.class).getResultList();
		System.out.println("List size: "+admins.size());
		
		
		em.getTransaction().begin();
		//em.createQuery("delete from Admin a").executeUpdate();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
	public static void main(String[] args) {
		new TestListenersOrder();
	}
}
