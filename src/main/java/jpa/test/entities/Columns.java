package jpa.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Columns {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition="VARCHAR_IGNORECASE(255)", nullable=false, updatable=false)
	private String name;
	//@Column(insertable=false, name="last_name")
	@Column(name="last_name")
	private String surname;
	
	public Columns() {}

	public Columns(String name, String surname) {
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
		return "Column [id=" + id + ", name=" + name + ", surname=" + surname
				+ "]";
	}
	
	
}
