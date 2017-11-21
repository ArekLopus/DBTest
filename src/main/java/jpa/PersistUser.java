package jpa;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;

public class PersistUser {

	public PersistUser() {
		//Switch libs in POM!!!!!
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUEcl");
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBTestPUHib");
        EntityManager em = emf.createEntityManager();
		
        //Persistence.generateSchema("DBTestPUEcl", null);
        //ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ValidatorFactory factory = Validation.byProvider( HibernateValidator.class ).configure().buildValidatorFactory();
        Validator validator = factory.getValidator();
        
        User u = new User("Marek","Garek");
        validator.validate(u, Default.class);
        factory.close();
        
		em.getTransaction().begin();
		em.persist(u);
		
		em.getTransaction().commit();
		em.clear();
		
		em.getTransaction().begin();
		u.setName("Arek");
		em.merge(u);
		em.getTransaction().commit();
		
		u = em.createNamedQuery("selectOneById", User.class).setParameter("id", u.getId()).getSingleResult();
		System.out.println("User: "+u);
		Object o = em.createQuery("select count(u) from User u").getSingleResult();
		System.out.println("Count: "+((Long)o));
		
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public static void main(String[] args) {
		new PersistUser();
	}

}
