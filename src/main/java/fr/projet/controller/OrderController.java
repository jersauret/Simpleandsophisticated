
package fr.projet.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.domain.Order;
import fr.projet.domain.criteria.OrderCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.services.OrderService;

@RestController
@RequestMapping("/admin/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Order create(@RequestBody Order order) throws BadRequestException {
		return orderService.save(order);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order findById(@PathVariable Long id) {
		return orderService.find(id);
	}
	
	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	public Order findOneByOrderNumber(@PathVariable String orderNumber) {
		return orderService.findOneByLogin(orderNumber);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Order> findAll() {
		return orderService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Order update(@PathVariable Long id, 
			@RequestBody Order order) {
		order.setId(id);
		return orderService.update(order);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Order delete(@PathVariable Long id) {
		return orderService.delete(id);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Order> search(@RequestParam(required = false) LocalDate purchaseDate,
			@RequestParam(required = false) Integer orderNumber,
			@RequestParam(required = false) Integer totalPrice
			) {
		

		
		OrderCriteria criteria = new OrderCriteria(purchaseDate, orderNumber, totalPrice);
		
		return orderService.search(criteria);
	}

}
