package jpa.test.entities.rs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;

@Entity
@NamedQuery(name = Artist.FIND_ALL, query="select a from Artist a")
public class Artist {
	public static final String FIND_ALL = "Artist.findAll";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "joined_art_cd", joinColumns = @JoinColumn(name = "artist_fk"), inverseJoinColumns = @JoinColumn(name = "cd_fk"))
	@OrderBy("title")
	//@OrderColumn(name="cd_idx")
	private List<CD> appearsOnCDs  = new LinkedList<>();
	//private List<CD> appearsOnCDs  = new ArrayList<>();
	
	public Artist() {}
	
	public Artist(String name, String surname) {
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

	public List<CD> getAppearsOnCDs() {
		return appearsOnCDs;
	}

	public void setAppearsOnCDs(List<CD> appearsOnCDs) {
		this.appearsOnCDs = appearsOnCDs;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", appearsOnCDs=" + appearsOnCDs + "]";
	}
	
	
	
}