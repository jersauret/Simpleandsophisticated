package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Basket;
import fr.projet.domain.Customer;
import fr.projet.domain.criteria.BasketCriteria;
import fr.projet.domain.criteria.CustomerCriteria;

@Repository
@Transactional
public class BasketJpaRepository extends AbstractJpaRepository<Basket> {

	public BasketJpaRepository() {
		super(Basket.class);
	}

	public List<Basket> searchWithCriterias(BasketCriteria basketCriteria) {
		String qlString = "from Basket b";

		if (basketCriteria.hasCriterias()) {
			qlString += " where 1=1";

			if (basketCriteria.getShippingCost() != null) {
				qlString += " and b.shippingCost = :shippingCost";
			}
			if (basketCriteria.getDiscount() != null) {
				qlString += " and b.discount = :discount ";
			}
		}

		TypedQuery<Basket> query = entityManager.createQuery(qlString, Basket.class);
		if (basketCriteria.hasCriterias()) {
			if (basketCriteria.getDiscount() != null) {
				query.setParameter("discount", basketCriteria.getDiscount());
			}
			if (basketCriteria.getShippingCost() != null) {
				query.setParameter("shippingCost", basketCriteria.getShippingCost());
			}
		}

		return query.getResultList();

	}

	public List<Basket> searchWithCriteria(BasketCriteria basketCriteria) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Basket> criteria = builder.createQuery(Basket.class);
		Root<Basket> root = criteria.from(Basket.class);
		if (basketCriteria.getDiscount() != null) {
			criteria.where(builder.equal(root.get("discount"), basketCriteria.getDiscount()));
		}
		if (basketCriteria.getShippingCost() != null) {
			criteria.where(builder.equal(root.get("shippingCost"), basketCriteria.getShippingCost()));
		}
		List<Basket> basket = entityManager.createQuery(criteria).getResultList();

		return basket;
	}

}
