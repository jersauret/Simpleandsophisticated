package fr.projet.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Basket;

@Repository
@Transactional
public class BasketJpaRepository extends AbstractJpaRepository<Basket> {

	public BasketJpaRepository() {
		super(Basket.class);
	}
	
}
