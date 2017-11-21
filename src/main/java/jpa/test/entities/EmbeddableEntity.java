package jpa.test.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import jpa.test.additionalclasses.EmbeddableKey;

@Entity
public class EmbeddableEntity {
	
	@EmbeddedId
	private EmbeddableKey key;
	private String name;
	private String surname;
	
	public EmbeddableEntity() {}
	
	public EmbeddableEntity(EmbeddableKey key, String name, String surname) {
		super();
		this.key = key;
		this.name = name;
		this.surname = surname;
	}


	public EmbeddableKey getKey() {
		return key;
	}

	public void setKey(EmbeddableKey key) {
		this.key = key;
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
		return "EmbeddableEntity [key=" + key + ", name=" + name + ", surname="	+ surname + "]";
	}
	
	
}
