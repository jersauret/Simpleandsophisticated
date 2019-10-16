package fr.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Order;
import fr.projet.domain.criteria.OrderCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.repository.OrderJpaRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderJpaRepository orderRepository;	
	
	public Order find(Long id) {
		return orderRepository.find(id);
	}
	
	public Order findOneByNumber(String orderNumber) {
		return orderRepository.findOneByNumber(orderNumber);
	}
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	@Transactional(readOnly = false)
	public Order save(Order order) throws BadRequestException {
		try {
			Order savedOrder = orderRepository.save(order);
			
			if (order.getCommandLine() != null) {
				order.getCommandLine().forEach(cl -> cl.setOrder(savedOrder));
			}
			return savedOrder;
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Order cannot be created with an id.", e);
		}
	}
	
	public Order update(Order order) {
		return orderRepository.update(order);
	}
	
	public Order delete(Long id) {
		return orderRepository.delete(id);
	}
	
	public List<Order> search(OrderCriteria criteria){
		return orderRepository.searchWithCriteria(criteria);
	}

	public Order findOneByUsername(String username) {
		return orderRepository.findOneByUsername(username);
	}
}
