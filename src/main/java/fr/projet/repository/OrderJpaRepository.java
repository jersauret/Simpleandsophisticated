package fr.projet.repository;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Order;

@Repository
@Transactional
public class OrderJpaRepository extends AbstractJpaRepository<Order> {

	public OrderJpaRepository() {
		super(Order.class);
	}
	
	public Order findOneByLogin(String login) {
		String qlString = "from Order u where u.login = :login";
		TypedQuery<Order> query = entityManager.createQuery(qlString, Order.class);
		query.setParameter("login", login);
		
		return query.getSingleResult();
	}
	
}
