package jpa.test.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class ElementCollectionsMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String surname;
	
	//@ElementCollection(fetch=FetchType.EAGER)
	@ElementCollection
	@CollectionTable(name="track")
	@MapKeyColumn(name = "position")
	private Map<Integer, String> tracks = new HashMap<>();
	
	
	public ElementCollectionsMap() {}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Map<Integer, String> getTracks() {
		return tracks;
	}
	
	public void setTracks(Map<Integer, String> tracks) {
		this.tracks = tracks;
	}


	@Override
	public String toString() {
		return "ElementCollections [id=" + id + ", surname=" + surname + ", tracks=" + tracks + "]";
	}
	
	
	
}
