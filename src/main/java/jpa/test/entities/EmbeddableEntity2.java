package jpa.test.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import jpa.test.additionalclasses.EmbeddableKey2;

@Entity
@IdClass(EmbeddableKey2.class)
public class EmbeddableEntity2 {
	
	@Id private String lang;
	@Id private String desc;
	private String name;
	private String surname;
	
	public EmbeddableEntity2() {}
	
	public EmbeddableEntity2(String lang, String desc, String name,	String surname) {
		this.lang = lang;
		this.desc = desc;
		this.name = name;
		this.surname = surname;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}





	@Override
	public String toString() {
		return "EmbeddableEntity2 [lang=" + lang + ", desc=" + desc + ", name="
				+ name + ", surname=" + surname + "]";
	}

	
	
}
