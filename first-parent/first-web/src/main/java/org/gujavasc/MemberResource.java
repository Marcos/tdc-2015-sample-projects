package org.gujavasc;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Path("members")

@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor(onConstructor=@__(@Inject))
@NoArgsConstructor
public class MemberResource {
	
	@Inject
	private MemberService memberService;

	@GET
	public Member getMemberStatus(){
		Member member = Member.builder().id(1L).name("Marcos").build();
		memberService.save(member);
		return member;
	}
	
}
