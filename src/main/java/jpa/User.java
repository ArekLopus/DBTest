package jpa;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

import jpa.listeners.UserListeners;

@EntityListeners(UserListeners.class)
@NamedQueries({
	@NamedQuery(name="selectAll", query="select u from User u"),
	@NamedQuery(name="selectOneById", query="select u from User u where u.id = :id ")
})

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Size(max=11)
	private String name;
	private String surname;
	
	public User() {	}

	public User(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname
				+ "]";
	}
	
	
}
