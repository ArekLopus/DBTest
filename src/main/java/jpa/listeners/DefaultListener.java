package jpa.listeners;

import javax.persistence.PostPersist;

public class DefaultListener {
	
	//Żeby działało jako def listener trzeba usunąć wykrzyknik w META-INF/!orm.xml
	//Powinno działać tez jako <mapping-file> w persistence.xml ale pokazuje błąd:
	//cvc-complex-type.2.4.a: Invalid content was found starting with element 'mapping-file'. One of '{"http://xmlns.jcp.org/xml/ns/persistence":class, "http://
	//xmlns.jcp.org/xml/ns/persistence":exclude-unlisted-classes, "http://xmlns.jcp.org/xml/ns/persistence":shared-cache-mode, "http://xmlns.jcp.org/xml/ns/
	//persistence":validation-mode, "http://xmlns.jcp.org/xml/ns/persistence":properties}' is expected.
	
	public DefaultListener() {}
	
	@PostPersist
	void prePersist(Object o) {
		System.out.println(o.getClass().getSimpleName()+", DefaultListener's @PostPersist called");
	}
	
	
}
