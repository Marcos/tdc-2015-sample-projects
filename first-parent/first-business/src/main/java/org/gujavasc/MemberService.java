package org.gujavasc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Stateless
@NoArgsConstructor
@AllArgsConstructor
public class MemberService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Member member){
		entityManager.persist(member);
	}
}
