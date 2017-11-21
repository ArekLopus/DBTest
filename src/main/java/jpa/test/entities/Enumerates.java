package jpa.test.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jpa.test.additionalclasses.EnumTypeMy;

@Entity
public class Enumerates {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	//@Enumerated(EnumType.ORDINAL)
	private EnumTypeMy myEnum;
	
	
	public Enumerates() {}	
	
	public Enumerates(EnumTypeMy myEnum) {
		super();
		this.myEnum = myEnum;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EnumTypeMy getEt() {
		return myEnum;
	}

	public void setEt(EnumTypeMy myEnum) {
		this.myEnum = myEnum;
	}
	
	
}
