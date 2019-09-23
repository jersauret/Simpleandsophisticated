package fr.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.domain.Basket;
import fr.projet.exception.BadRequestException;
import fr.projet.services.BasketService;

@RestController
@RequestMapping("/admin/basket/")
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Basket create(@RequestBody Basket user) throws BadRequestException {
		return basketService.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Basket findById(@PathVariable Long id) {
		return basketService.find(id);
	}
	
	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	public Basket findOneByLogin(@PathVariable String login) {
		return basketService.findOneByLogin(login);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Basket> findAll() {
		return basketService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Basket update(@PathVariable Long id, 
			@RequestBody Basket user) {
		user.setId(id);
		return basketService.update(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Basket delete(@PathVariable Long id) {
		return basketService.delete(id);
	}

}
