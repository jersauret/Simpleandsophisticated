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

import fr.projet.domain.Product;
import fr.projet.exception.BadRequestException;
import fr.projet.services.ItemService;

@RestController
@RequestMapping("/admin/items/")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product user) throws BadRequestException {
		return itemService.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		return itemService.find(id);
	}
	
	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	public Product findOneByLogin(@PathVariable String login) {
		return itemService.findOneByLogin(login);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAll() {
		return itemService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Product update(@PathVariable Long id, 
			@RequestBody Product user) {
		user.setId(id);
		return itemService.update(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Product delete(@PathVariable Long id) {
		return itemService.delete(id);
	}

}
