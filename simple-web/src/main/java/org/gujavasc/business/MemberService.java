package org.gujavasc.business;
import static org.gujavasc.entities.QMember.member;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.gujavasc.entities.Member;
import org.gujavasc.query.QueryFactory;

import com.mysema.query.jpa.impl.JPAQuery;


@Stateless
@NoArgsConstructor
@AllArgsConstructor
public class MemberService {

	@Inject
	private QueryFactory queryFactory;
	
	public void save(Member member){
		queryFactory.persist(member);
	}

	public List<Member> list() {
		return queryFactory.from(member).list(member);
	}	

}
