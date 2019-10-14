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

import fr.projet.domain.Customer;
import fr.projet.exception.BadRequestException;
import fr.projet.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Customer create(@RequestBody Customer user) throws BadRequestException {
		return customerService.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer findById(@PathVariable Long id) {
		return customerService.find(id);
	}
	
	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	public Customer findOneByLogin(@PathVariable String login) {
		return customerService.findOneByLogin(login);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> findAll() {
		return customerService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Customer update(@PathVariable Long id, 
			@RequestBody Customer user) {
		user.setId(id);
		return customerService.update(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Customer delete(@PathVariable Long id) {
		return customerService.delete(id);
	}

}
