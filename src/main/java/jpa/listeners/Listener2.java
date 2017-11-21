package jpa.listeners;

import javax.persistence.PostPersist;

public class Listener2 {
	
	public Listener2() {}
	
	@PostPersist
	void prePersist(Object o) {
		System.out.println(o.getClass().getSimpleName()+", "+o.getClass().getSuperclass()+", "+"Listener2's @PostPersist called");
	}
	
	
}
