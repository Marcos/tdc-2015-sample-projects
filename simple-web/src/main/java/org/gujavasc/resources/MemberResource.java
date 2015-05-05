package org.gujavasc.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.gujavasc.business.MemberService;
import org.gujavasc.entities.Member;

@Path("member")

@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor(onConstructor=@__(@Inject))
@NoArgsConstructor
public class MemberResource {
	
	private MemberService memberService;

	@POST
	public Member save(){
		Member member = Member.builder()
						.id(1L)
						.name("Marcos")
						.build();
		memberService.save(member);
		return member;
	}
	
	@GET
	public List<Member> list(){
		return memberService.list();
	}
	
}
