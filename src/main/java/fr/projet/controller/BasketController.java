package fr.projet.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.domain.Basket;
import fr.projet.domain.Order;
import fr.projet.domain.criteria.BasketCriteria;
import fr.projet.domain.criteria.OrderCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.services.BasketService;

@RestController
@RequestMapping("/baskets")
public class BasketController {

	@Autowired
	private BasketService basketService;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Basket findById(@PathVariable Long id) {
		return basketService.find(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Basket> findAll() {
		return basketService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Basket update(@PathVariable Long id, @RequestBody Basket user) {
		user.setId(id);
		return basketService.update(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Basket delete(@PathVariable Long id) {
		return basketService.delete(id);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Basket> search (@RequestParam(required = false) Integer discount,
	@RequestParam(required = false) Integer shippingCost
	){

		BasketCriteria criteria = new BasketCriteria(discount, shippingCost);

		return basketService.search(criteria);
	}

}
