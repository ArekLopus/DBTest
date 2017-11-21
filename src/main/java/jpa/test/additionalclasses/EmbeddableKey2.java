package jpa.test.additionalclasses;


public class EmbeddableKey2 {
	
	private String lang;
	private String desc;
	
	public EmbeddableKey2() {}
	
	public EmbeddableKey2(String lang, String desc) {
		super();
		this.lang = lang;
		this.desc = desc;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmbeddableKey2 other = (EmbeddableKey2) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmbeddableKey2 [lang=" + lang + ", desc=" + desc + "]";
	}
	
	
	
}
