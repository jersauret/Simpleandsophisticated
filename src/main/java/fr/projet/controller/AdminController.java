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

import fr.projet.domain.Admin;
import fr.projet.exception.BadRequestException;
import fr.projet.services.AdminService;

@RestController
@RequestMapping("/admin/administrators/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Admin create(@RequestBody Admin user) throws BadRequestException {
		return adminService.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Admin findById(@PathVariable Long id) {
		return adminService.find(id);
	}
	
	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	public Admin findOneByLogin(@PathVariable String login) {
		return adminService.findOneByLogin(login);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Admin> findAll() {
		return adminService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Admin update(@PathVariable Long id, 
			@RequestBody Admin user) {
		user.setId(id);
		return adminService.update(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Admin delete(@PathVariable Long id) {
		return adminService.delete(id);
	}

}
