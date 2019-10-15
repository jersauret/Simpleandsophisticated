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

import fr.projet.domain.Customer;
import fr.projet.domain.criteria.CustomerCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.services.CustomerService;

@RestController

@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Customer create(@RequestBody Customer user) { //throws BadRequestException {
		try {
			return customerService.save(user);
		} catch (BadRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer findById(@PathVariable Long id) {
		return customerService.find(id);
	}
	
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public Customer findOneByLogin(@PathVariable String email) {
		return customerService.findOneByEmail(email);
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
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Customer> search(@RequestParam(required = false) String login,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String street,
			@RequestParam(required = false) Integer streetNumber,
			@RequestParam(required = false) LocalDate dOB,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String country,
			@RequestParam(required = false) String zipCode,
			@RequestParam(required = false) String eMail,
			@RequestParam(required = false) String phoneNumber

			) {

		
		CustomerCriteria criteria = new CustomerCriteria(login, firstName, lastName, street, streetNumber, dOB, password, city, country, zipCode, eMail, phoneNumber);
		return customerService.search(criteria);
	}
}
