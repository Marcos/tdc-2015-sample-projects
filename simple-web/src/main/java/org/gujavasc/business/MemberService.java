package org.gujavasc.business;
import static org.gujavasc.entities.QMember.member;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.gujavasc.entities.Member;

import com.mysema.query.jpa.impl.JPAQuery;


@Stateless
@NoArgsConstructor
@AllArgsConstructor
public class MemberService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Member member){
		entityManager.persist(member);
	}

	public List<Member> list() {
		JPAQuery query = new JPAQuery(entityManager);
		return query.from(member).list(member);
	}	

}
