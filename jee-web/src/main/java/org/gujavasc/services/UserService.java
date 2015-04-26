package org.gujavasc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.gujavasc.entities.User;

@Stateless
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private PaymentService paymentService;

	public User save(User user) {
		saveOrUpdate(user);
		paymentService.update(user);
		return user;
	}

	private void saveOrUpdate(User user) {
		Long userId = findIdByEmail(user.getEmail());
		if (userId == null)
			entityManager.persist(user);
		else {
			user.setId(userId);
			entityManager.merge(user);
		}
	}

	private Long findIdByEmail(String email) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<User> user = criteriaQuery.from(User.class);
		criteriaQuery.select(user.get("id"));
		criteriaQuery.where(criteriaBuilder.equal(user.get("email"),
				criteriaBuilder.parameter(String.class, "email")));

		TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
		query.setParameter("email", email);
		List<Long> results = query.getResultList();
		if (!results.isEmpty())
			return results.get(0);
		return null;
	}

	public List<User> list() {
		CriteriaQuery<User> criteriaQuery = entityManager
				.getCriteriaBuilder()
				.createQuery(User.class);
		criteriaQuery.from(User.class);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
