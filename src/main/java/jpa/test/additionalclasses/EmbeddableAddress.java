package jpa.test.additionalclasses;

import javax.persistence.Embeddable;

@Embeddable
public class EmbeddableAddress {
	
	private String street;
	private String city;
	
	public EmbeddableAddress() {}

	public EmbeddableAddress(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "EmbeddableAddress [street=" + street + ", city=" + city + "]";
	}
	
}
