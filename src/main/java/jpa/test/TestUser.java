package jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.test.entities.User2;
import util.Util;


public class TestUser {

	public TestUser() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
		
        User2 u = Util.getRandomUser2();
        
		em.getTransaction().begin();
		em.persist(u);
		
		em.getTransaction().commit();
		em.clear();
		
		List<User2> list = em.createQuery("select u from User2 u", User2.class).setMaxResults(3).getResultList();
		Object o = em.createQuery("select count(u) from User2 u").getSingleResult();
		System.out.println("Count: "+((Long)o));
		System.out.println("Users2: "+list);
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestUser();
	}

}
