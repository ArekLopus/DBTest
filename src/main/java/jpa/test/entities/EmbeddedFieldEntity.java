package jpa.test.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import jpa.test.additionalclasses.EmbeddableAddress;

@Entity
public class EmbeddedFieldEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String surname;
	@Embedded
	private EmbeddableAddress address;
	
	public EmbeddedFieldEntity() {}
	
	public EmbeddedFieldEntity(String name, String surname,	EmbeddableAddress address) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
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

	public EmbeddableAddress getAddress() {
		return address;
	}

	public void setAddress(EmbeddableAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmbeddedFieldEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + "]";
	}

	
	
	
}
