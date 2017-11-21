package jpa.test.listener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

import jpa.listeners.Listener1;
import jpa.listeners.Listener2;
import jpa.listeners.UserListeners;

@EntityListeners({Listener1.class, Listener2.class})
//@ExcludeDefaultListeners
//@ExcludeSuperclassListeners
@Entity
public class Admin extends Person {
	
	private String rights;
	
	public Admin() {	}

	public Admin(String name, String surname, String rights) {
		super(name, surname);
		this.rights = rights;
	}
	
	
	

	@Override
	public String toString() {
		return "Admin [id=" + super.getId() + ", name=" + super.getName() + ", surname=" + super.getSurname()
				+ ", rights=" + this.rights + "]";
	}
	
	
}
