package org.gujavasc.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.gujavasc.entities.User;
import org.jugavasc.services.UserService;

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
