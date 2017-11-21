package jpa.test.entities.rs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CD implements Comparable<CD>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private Float price;
	
	@ManyToMany(mappedBy = "appearsOnCDs", fetch=FetchType.EAGER)
	//@ManyToMany()
	private List<Artist> createdByArtists = new ArrayList<>();
	
	public CD() {}
	
	
	public CD(String title, Float price) {
		super();
		this.title = title;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<Artist> getCreatedByArtists() {
		return createdByArtists;
	}

	public void setCreatedByArtists(List<Artist> createdByArtists) {
		this.createdByArtists = createdByArtists;
	}
	
	

	@Override
	public String toString() {
		return "CD [id=" + id + ", title=" + title + ", price=" + price + "]";
	}


	@Override
	public int compareTo(CD o) {
		return this.title.compareTo(o.getTitle());
	}

	
}