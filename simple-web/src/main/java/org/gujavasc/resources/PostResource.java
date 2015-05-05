package org.gujavasc.resources;

import static com.contaazul.dsl.DateDsl.date;
import static org.gujavasc.entities.Status.DRAFT;
import static org.gujavasc.entities.Status.PUBLISHED;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gujavasc.business.MemberService;
import org.gujavasc.business.PostService;
import org.gujavasc.entities.Member;
import org.gujavasc.entities.Post;
import org.gujavasc.entities.Status;

@Path("post")
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

	@Inject
	private PostService postService;
	@Inject
	private MemberService memberService;

	@GET
	public List<Post> list(){
		return postService.list();
	}
	
	@GET
	@Path("all")
	public List<Post> listAll(){
		return postService.listAll();
	}
	
	@GET
	@Path("drafts")
	public List<Post> listDrafts(){
		return postService.listDrafts();
	}
	
	@GET
	@Path("publisheds")
	public List<Post> listPublisheds(){
		return postService.listPublisheds();
	}
	
	@POST
	@Path("publish")
	public void publishAll(){
		postService.publishAll();
	}
	
	@POST
	public void populate() {
		Member john = Member.builder().name("John").build();
		memberService.save(john);
		Member vini = Member.builder().name("Vini").build();
		memberService.save(vini);
		Member joseph = Member.builder().name("Joseph").build();
		memberService.save(joseph);
		
		postService.save(createPost(john, "querydsl", "Post sobre querydsl", DRAFT));
		postService.save(createPost(vini, "lombok", "Post sobre lombok", DRAFT));
		postService.save(createPost(joseph, "startup", "Post sobre startups", PUBLISHED));
		postService.save(createPost(null, "First anonymous post", "It is anonymous", PUBLISHED));
		postService.save(createPost(null, "First anonymous post", "It also is anonymous", DRAFT));
	}

	private Post createPost(Member member, String title, String content, Status status) {
		return Post.builder()
				.member(member)
				.title(title)
				.content(content)
				.status(status)
				.date(date().toDate())
				.build();
	}

}
