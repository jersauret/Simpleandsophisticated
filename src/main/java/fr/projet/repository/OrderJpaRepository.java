package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import fr.projet.domain.Order;
import fr.projet.domain.criteria.OrderCriteria;
import fr.projet.services.UserService;

@Repository
@Transactional
public class OrderJpaRepository extends AbstractJpaRepository<Order> {
	
	@Autowired
	UserService userService;

	public OrderJpaRepository() {
		super(Order.class);
	}

	public Order findOneByNumber(String orderNumber) {
		String qlString = "from Order o where o.orderNumber = :orderNumber";
		TypedQuery<Order> query = entityManager.createQuery(qlString, Order.class);
		query.setParameter("orderNumber", orderNumber);


		return query.getSingleResult();
	}

	public List<Order> search(OrderCriteria criteria) {
		String qlString = "from Order o";

		if (criteria.hasCriterias()) {
			qlString += " where 1=1";

			if (StringUtils.isEmpty(criteria.getOrderNumber())) {
				qlString += " and lower(o.orderNumber) like lower(:orderNumber)";
				
			}
			if (criteria.getTotalPrice()!= null) {
				qlString += " and o.totalPrice = :totalPrice";
			}
			if (criteria.getPurchaseDate()!= null) {
				qlString += " and o.purchaseDate = :purchaseDate";
			}
			if(criteria.getCommandStatus() != null) {
				qlString += " and o.commandStatus = :commandStatus";
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
			if (criteria.getCommandStatus() !=null) {
				query.setParameter("commandStatus", criteria.getCommandStatus());
			}
		}

		return query.getResultList();
	}

	public List<Order> searchWithCriteria(OrderCriteria orderCritera) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Order> criteria = builder.createQuery(Order.class);
		Root<Order> root = criteria.from(Order.class);

		if (orderCritera.getPurchaseDate() != null) {
			criteria.where(builder.equal(root.get("purchaseDate"), orderCritera.getPurchaseDate() ));
		}
		if (!StringUtils.isEmpty(orderCritera.getOrderNumber())) {
			criteria.where(builder.like(root.get("orderNumber"), "%" + orderCritera.getOrderNumber() + "%"));
		}
		if (orderCritera.getTotalPrice() != null) {
			criteria.where(builder.equal(root.get("totalPrice"), orderCritera.getTotalPrice()));
		}
		if(orderCritera.getCommandStatus() != null) {
			criteria.where(builder.equal(root.get("commandStatus"), orderCritera.getCommandStatus()));
		}
		

		List<Order> orders = entityManager.createQuery(criteria).getResultList();
		return orders;
	}

	public Order findOneByOrderId(String orderNumber) {
		String qlString = "from Order u where u.ordernumber = :orderNumber";
		TypedQuery<Order> query = entityManager.createQuery(qlString, Order.class);
		query.setParameter("orderNumber", orderNumber);
		return query.getSingleResult();
	}
	
	public List<Order> findAllOrdersByUserId(Long userId) {
		String qlString = "from Order o where o.user.id = :user_id";
		TypedQuery<Order> query = entityManager.createQuery(qlString, Order.class);
		query.setParameter("user_id", userId);
		return query.getResultList();
	}

	
}
