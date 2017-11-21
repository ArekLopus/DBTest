package jpa.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import jpa.User;


public class UserListeners {

	public UserListeners() {}
	
	@PrePersist
	void prePersist(User u) {
		System.out.println("@PrePersist");
	}
	
	@PostPersist
	void postPersist(User u) {
		System.out.println("@PostPersist");
	}
	
	@PreUpdate
	void preUpdate(User u) {
		System.out.println("@PreUpdate");
	}
	
	@PostUpdate
	void postUpdate(User u) {
		System.out.println("@PostUpdate");
	}
	
	@PreRemove
	void preRemove(User u) {
		System.out.println("@PreRemove");
	}
	
	@PostRemove
	void postRemove(User u) {
		System.out.println("@PostRemove");
	}
	
	@PostLoad
	void postLoad(User u) {
		System.out.println("@PostLoad");
	}
	
}
