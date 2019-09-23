package fr.projet.repository;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Basket;

@Repository
@Transactional
public class BasketJpaRepository extends AbstractJpaRepository<Basket> {

	public BasketJpaRepository() {
		super(Basket.class);
	}
	
	public Basket findOneByLogin(String login) {
		String qlString = "from Basket u where u.login = :login";
		TypedQuery<Basket> query = entityManager.createQuery(qlString, Basket.class);
		query.setParameter("login", login);
		
		return query.getSingleResult();
	}
}
