package org.gujavasc.services;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.gujavasc.entities.User;

@Stateless
public class PaymentService {
	
	@Asynchronous
	@TransactionAttribute(NOT_SUPPORTED)
	public void update(User user){
		System.out.println("System is too busy! Calm down!");
		fakeBusy();
		System.out.println("User updated: " + user.getEmail());
	}

	private void fakeBusy() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Ops!");
		}
	}

}
