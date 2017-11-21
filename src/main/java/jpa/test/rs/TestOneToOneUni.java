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
import jpa.test.entities.rs.Customer;
import util.Util;


public class TestOneToOneUni {

	public TestOneToOneUni() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
        
        Address ad = new Address("Poznańska 11", "Warsaw");
        Customer cu = new Customer("Arek", "Garek");
        ad.setCustomer(cu);
        cu.setAddress(ad);
        
		em.getTransaction().begin();
		em.persist(ad);
		em.persist(cu);
		
		em.getTransaction().commit();
		em.clear();
		
		ad = em.find(Address.class, ad.getId());
		cu = em.find(Customer.class, ad.getId());
		System.out.println("\nCustomer: "+cu);
		System.out.println("Address:   "+ad+"\n");
		
//		em.getTransaction().begin();
//		em.remove(o);
//		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new TestOneToOneUni();
	}

}
