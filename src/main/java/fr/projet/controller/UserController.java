package fr.projet.controller;

import java.time.LocalDate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.domain.User;
import fr.projet.domain.criteria.UserCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService clientService;

	//@PreAuthorize("hasAuthority('C_USER')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) { // throws BadRequestException {
		try {
			return clientService.save(user);
		} catch (BadRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	//@PreAuthorize("hasRole('ADMIN')")
	//@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		return clientService.find(id);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	//@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public User findOneByMail(@PathVariable String email) {
		return clientService.findOneByEmail(email);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	//@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return clientService.findAll();
	}

	//@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	//@PostAuthorize("hasRole('ADMIN') or #returnObject.customer.email == principal.username")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		return clientService.update(user);
	}

	//@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	//@PostAuthorize("hasRole('ADMIN') or #returnObject.customer.email == principal.username")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public User delete(@PathVariable Long id) {
		return clientService.delete(id);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	//@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> search(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String username, @RequestParam(required = false) String lastName,
			@RequestParam(required = false) String street, @RequestParam(required = false) Integer streetNumber,
			@RequestParam(required = false) LocalDate dOB, @RequestParam(required = false) String password,
			@RequestParam(required = false) String city, @RequestParam(required = false) String country,
			@RequestParam(required = false) String zipCode, @RequestParam(required = false) String email,
			@RequestParam(required = false) String phoneNumber

	) {
		UserCriteria clientCriteria = new UserCriteria(email, firstName, lastName, password, street, streetNumber, dOB,
				city, country, zipCode, phoneNumber);
		return clientService.searchClient(clientCriteria);
	}
}
