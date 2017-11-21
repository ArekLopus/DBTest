package jpa.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

public class User2XML {
	
	private int id;
	private String name;
	private String surname;
	
	public User2XML() {}

	public User2XML(String name, String surname) {
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
		return "User2WithNoAnnotations [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
}
