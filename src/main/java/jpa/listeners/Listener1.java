package jpa.listeners;

import javax.persistence.PostPersist;

public class Listener1 {
	
	public Listener1() {}
	
	@PostPersist
	void prePersist(Object o) {
		System.out.println(o.getClass().getSimpleName()+", "+o.getClass().getSuperclass()+", "+"Listener1's @PostPersist called");
	}
	
	
}
