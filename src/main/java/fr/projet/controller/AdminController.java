package fr.projet.controller;

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

import fr.projet.domain.User;
import fr.projet.domain.criteria.UserCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.services.UserService;

@RestController

@RequestMapping("/api/admins")
public class AdminController {
	
	@Autowired
	private UserService adminService;
	
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		return adminService.find(id);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return adminService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, 
			@RequestBody User user) {
		user.setId(id);
		return adminService.update(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public User delete(@PathVariable Long id) {
		return adminService.delete(id);
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> search(@RequestParam(required = false) String username,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String eMail

			) {

		
		UserCriteria adminCriteria = new UserCriteria(eMail, username, password, firstName, lastName);
		return adminService.searchAdmin(adminCriteria);
	}

	
}
