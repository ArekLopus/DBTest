package jpa.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="selectAllU2", query="select u from User2 u"),
	@NamedQuery(name="selectOneByIdU2", query="select u from User2 u where u.id = :id ")
})

@Entity
public class User2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="myGen")
	private int id;
	private String name;
	private String surname;
	
	public User2() {}

	public User2(String name, String surname) {
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
		return "User2 [id=" + id + ", name=" + name + ", surname=" + surname
				+ "]";
	}
	
	
}
