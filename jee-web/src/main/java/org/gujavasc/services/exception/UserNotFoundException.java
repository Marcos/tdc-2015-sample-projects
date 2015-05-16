package org.gujavasc.services.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -7964084330489908041L;
	
	public UserNotFoundException() {
		super("Usuário não encontrado");
	}

}
