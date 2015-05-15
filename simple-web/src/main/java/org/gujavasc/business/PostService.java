package org.gujavasc.business;

import static org.gujavasc.entities.QMember.member;
import static org.gujavasc.entities.QPost.create;
import static org.gujavasc.entities.QPost.post;
import static org.gujavasc.entities.Status.DRAFT;
import static org.gujavasc.entities.Status.PUBLISHED;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.gujavasc.entities.Post;
import org.gujavasc.entities.QPost;
import org.gujavasc.entities.Status;

import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;

@Stateless
public class PostService {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Post post) {
		entityManager.persist(post);
	}

	public List<Post> findDrafts(){
		return new JPAQuery(entityManager)
		.from(post)
		.where(post.id
				.in(new JPASubQuery()
				.from(post)
				.where(
						post.status.eq(DRAFT))
						.list(post.id))
						)
		.list(post);
	}

	public List<Post> list() {
		JPAQuery query = createQuery();
		return query.from(post).innerJoin(post.member, member)
				.list(create(member.name, post.title, post.content));
	}

	public List<Post> listAll() {
		JPAQuery query = createQuery();
		return query.from(post).leftJoin(post.member, member)
				.list(create(member.name, post.title, post.content));
	}

	public List<Post> listDrafts() {
		JPAQuery query = createQuery();
		return query.from(post).leftJoin(post.member, member)
				.where(post.status.eq(DRAFT))
				.list(create(member.name, post.title, post.content));
	}

	public List<Post> listPublisheds() {
		JPAQuery query = createQuery();
		return query.from(post).leftJoin(post.member, member)
				.where(post.status.eq(PUBLISHED))
				.list(create(member.name, post.title, post.content));
	}

	public void publishAll() {
		new JPAUpdateClause(entityManager, post).set(post.status,
				Status.PUBLISHED).execute();
	}

	public void clearAll() {
		new JPADeleteClause(entityManager, post).where(
				post.status.in(Status.PUBLISHED, Status.DRAFT)).execute();
	}

	private JPAQuery createQuery() {
		return new JPAQuery(entityManager);
	}

}
