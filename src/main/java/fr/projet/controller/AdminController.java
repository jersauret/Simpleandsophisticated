package fr.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import fr.projet.domain.User;
import fr.projet.domain.criteria.UserCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admins")
public class AdminController {
	
	@Autowired
	private UserService adminService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User admin) {//throws BadRequestException {
		try {
			return adminService.save(admin);
		} catch (BadRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		return adminService.find(id);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return adminService.findAll();
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, 
			@RequestBody User user) {
		user.setId(id);
		return adminService.update(user);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public User delete(@PathVariable Long id) {
		return adminService.delete(id);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> search(
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String eMail

			) {

		
		UserCriteria adminCriteria = new UserCriteria(eMail, password, firstName, lastName);
		return adminService.searchAdmin(adminCriteria);
	}

	
}
