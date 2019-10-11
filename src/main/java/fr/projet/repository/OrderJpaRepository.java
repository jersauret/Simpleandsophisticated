package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import fr.projet.domain.Order;
import fr.projet.domain.criteria.OrderCriteria;

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

	public List<Order> search(OrderCriteria criteria) {
		String qlString = "from Order o";

		if (criteria.hasCriterias()) {
			qlString += " where 1=1";

			if (criteria.getOrderNumber()!= null) {
				qlString += " and o.orderNumber = :orderNumber";
			}
			if (criteria.getTotalPrice()!= null) {
				qlString += " and o.totalPrice = :totalPrice";
			}
			if (criteria.getPurchaseDate()!= null) {
				qlString += " and o.purchaseDate = :purchaseDate";
			}
			
		}

		TypedQuery<Order> query = entityManager.createQuery(qlString, Order.class);

		if (criteria.hasCriterias()) {
			if(criteria.getTotalPrice() !=null) {
				query.setParameter("totalPrice", criteria.getTotalPrice());
			}
			if (criteria.getOrderNumber() != null) {
				query.setParameter("orderNumber", criteria.getOrderNumber());
			}
			if (criteria.getPurchaseDate() != null) {
				query.setParameter("purchaseDate", criteria.getPurchaseDate());
			}
		}

		return query.getResultList();
	}

	public List<Order> searchWithCriteria(OrderCriteria orderCritera) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Order> criteria = builder.createQuery(Order.class);
		Root<Order> root = criteria.from(Order.class);

		if (!StringUtils.isEmpty(orderCritera.getPurchaseDate())) {
			criteria.where(builder.like(root.get("purchaseDate"), "%" + orderCritera.getPurchaseDate() + "%"));
		}
		if (!StringUtils.isEmpty(orderCritera.getOrderNumber())) {
			criteria.where(builder.like(root.get("orderNumber"), "%" + orderCritera.getOrderNumber() + "%"));
		}
		if (!StringUtils.isEmpty(orderCritera.getTotalPrice())) {
			criteria.where(builder.like(root.get("totalPrice"), "%" + orderCritera.getTotalPrice() + "%"));
		}

		List<Order> orders = entityManager.createQuery(criteria).getResultList();

		return orders;
	}

}
