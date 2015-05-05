package org.gujavasc.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.gujavasc.entities.User;
import org.gujavasc.services.UserService;
import org.gujavasc.services.exception.UserNotFoundException;

@Path("user")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class UserResource {
	
	@Inject
	private UserService userService;
	
	@POST
	public User save(User user){
		return userService.save(user);
	}
	
	@GET
	public List<User> list(){
		return userService.list();
	}
	
	@GET
	@Path("{email}")
	public User find(@PathParam("email") String email) throws UserNotFoundException{
		return userService.find(email);
	}
	
	@GET
	@Path("sample")
	public User getUser(){
		return User.builder()
					.id(1L)
					.name("Marcos")
					.email("marcos@contaazul.com")
					.age(30)
				.build();
	}

}
