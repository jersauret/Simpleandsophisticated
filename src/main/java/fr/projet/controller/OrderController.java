
package fr.projet.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PreAuthorize("hasAuthority('C_ORDER')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Order create(@RequestBody Order order) { // throws BadRequestException {
		try {
			return orderService.save(order);
		} catch (BadRequestException e) {
			e.printStackTrace();
			return null;
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order findById(@PathVariable Long id) {
		return orderService.find(id);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@PostAuthorize("hasRole('ADMIN') or returnObject.user.email == principal.username")
	@RequestMapping(value = "/orderNumber/{orderNumber}", method = RequestMethod.GET)
	public Order findOneByOrderNumber(@PathVariable String orderNumber) {
		Order o = orderService.findOneByNumber(orderNumber);
		System.out.println(o);
		return o;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<Order> findAll() {
		List<Order> orders = orderService.findAll();

		System.out.println(orders);

		return orders;
	}

	@PreAuthorize("hasRole('ADMIN') or (hasRole('CUSTOMER') and  @securityService.isConnectedUser(#id))")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public List<Order> findAllOrdersByUserEmail(@PathVariable Long id) {
		List<Order> orders = orderService.findAllOrdersByUserId(id);

		System.out.println(orders);
		System.out.println("############################################################");
		return orders;
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Order update(@PathVariable Long id, @RequestBody Order order) {
		order.setId(id);
		return orderService.update(order);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Order delete(@PathVariable Long id) {
		return orderService.delete(id);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@PostAuthorize("hasRole('ADMIN') or returnObject.customer.email == principal.username")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Order> search(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate purchaseDate,
			@RequestParam(required = false) String orderNumber, @RequestParam(required = false) Integer totalPrice) {

		OrderCriteria criteria = new OrderCriteria(purchaseDate, orderNumber, totalPrice);

		return orderService.search(criteria);

	}

}
