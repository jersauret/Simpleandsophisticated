package fr.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.domain.Basket;
import fr.projet.domain.criteria.BasketCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.services.BasketService;

@RestController

@RequestMapping("/api/baskets")
public class BasketController {

	@Autowired
	private BasketService basketService;

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@PostAuthorize("hasRole('ADMIN') or #returnObject.customer.email == principal.username")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Basket create(@RequestBody Basket user) { // throws BadRequestException {
		try {
			return basketService.save(user);
		} catch (BadRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@PostAuthorize("hasRole('ADMIN') or #returnObject.customer.email == principal.username")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Basket findById(@PathVariable Long id) {
		return basketService.find(id);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<Basket> findAll() {
		return basketService.findAll();
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@PostAuthorize("hasRole('ADMIN') or #returnObject.customer.email == principal.username")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Basket update(@PathVariable Long id, @RequestBody Basket user) {
		user.setId(id);
		return basketService.update(user);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@PostAuthorize("hasRole('ADMIN') or #returnObject.customer.email == principal.username")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Basket delete(@PathVariable Long id) {
		return basketService.delete(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Basket> search (@RequestParam(required = false) Integer discount,
	@RequestParam(required = false) Integer shippingCost
	){

		BasketCriteria criteria = new BasketCriteria(discount, shippingCost);

		return basketService.search(criteria);
	}

}
