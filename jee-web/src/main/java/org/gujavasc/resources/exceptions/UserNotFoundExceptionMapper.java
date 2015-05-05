package org.gujavasc.resources.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.gujavasc.services.exception.UserNotFoundException;

@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

	@Override
	public Response toResponse(UserNotFoundException exception) {
		Error error = new Error(exception.getMessage());
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}
}
