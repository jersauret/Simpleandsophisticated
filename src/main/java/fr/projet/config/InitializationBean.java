package fr.projet.config;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fr.projet.domain.CommandLine;
import fr.projet.domain.Customer;
import fr.projet.domain.Order;
import fr.projet.domain.Right;
import fr.projet.domain.Role;
import fr.projet.domain.User;
import fr.projet.exception.BadRequestException;
import fr.projet.repository.CustomerJpaRepository;
import fr.projet.repository.OrderJpaRepository;
import fr.projet.repository.RightRepository;
import fr.projet.repository.RoleRepository;
import fr.projet.repository.UserRepository;
import fr.projet.services.CustomerService;

@Component
public class InitializationBean {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RightRepository rightRepository;
	
	@Autowired
	private OrderJpaRepository orderRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private CustomerJpaRepository customerRepository;
	

	@PostConstruct
	public void init() throws BadRequestException {

		if (userRepository.findAll().isEmpty()) {
			Right createProductRight = new Right("C_PRODUCT");
			Right createOrderRight = new Right("C_ORDER");
			Right createUserRight = new Right("C_USER");
			Right readOrderRight = new Right("R_ORDER");
			Right readProductRight = new Right("R_PRODUCT");
			
			rightRepository.save(createProductRight);
			rightRepository.save(createOrderRight);
			rightRepository.save(createUserRight);
			rightRepository.save(readOrderRight);
			rightRepository.save(readProductRight);

			List<Right> rightsVisitorList = new ArrayList<Right>();
			rightsVisitorList.add(readProductRight);
			
			List<Right> rightsCustomerList = new ArrayList<Right>();
			rightsCustomerList.addAll(rightsVisitorList);
			rightsCustomerList.add(readOrderRight);
			
			List<Right> rightsAdminList = new ArrayList<Right>();
			rightsAdminList.addAll(rightsCustomerList);
			rightsAdminList.add(createProductRight);
			rightsAdminList.add(createOrderRight);
			rightsAdminList.add(createUserRight);
			
			Role adminRole = new Role("ADMIN");
			adminRole.setRights(rightsAdminList);
			Role customerRole = new Role("CUSTOMER");
			customerRole.setRights(rightsCustomerList);
			Role visitorRole = new Role("VISITOR");
			visitorRole.setRights(rightsVisitorList);
			
			roleRepository.save(adminRole);
			roleRepository.save(customerRole);
			roleRepository.save(visitorRole);
			
			
			
			
			User userAdmin = new User("admin", encoder.encode("admin"), "admin@sas.net");
			userAdmin.setRole(adminRole);
			User userCustomer = new User("customer", encoder.encode("customer"), "customer@sas.net");
			userCustomer.setRole(customerRole);
			User userVisitor = new User("visitor", encoder.encode("visitor"), "visitor@sas.net");
			userVisitor.setRole(visitorRole);
			
			userRepository.save(userAdmin);
			userRepository.save(userCustomer);
			userRepository.save(userVisitor);
			
			
			/*
			 * String login, String firstName, String lastName, String street, Integer streetNumber, LocalDate dOB,
			String password, String city, String country, String zipCode, String eMail
			 */
			
			Customer customer1 = new Customer("TahitiBob", "Milton", "Eustache", "test", 666, LocalDate.of(1994,12,31), "test", "test", "France", "34070", "m.eustache@sas.net");
			Order orderCustomer= new Order(LocalDate.of(2019,01,01), customer1);
			List<CommandLine> commandeligne = new ArrayList<CommandLine>();
			commandeligne.add(null);
			commandeligne.add(null);
			
			customerRepository.save(customer1);
			orderRepository.save(orderCustomer);
		}
	}
}
