package fr.projet.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fr.projet.domain.CategoryType;
import fr.projet.domain.CommandLine;
import fr.projet.domain.Order;
import fr.projet.domain.Product;
import fr.projet.domain.ProductType;
import fr.projet.domain.Right;
import fr.projet.domain.Role;
import fr.projet.domain.User;
import fr.projet.exception.BadRequestException;
import fr.projet.repository.OrderJpaRepository;
import fr.projet.repository.ProductJpaRepository;
import fr.projet.repository.RightRepository;
import fr.projet.repository.RoleRepository;
import fr.projet.repository.UserRepository;

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
	private ProductJpaRepository productJpaRepository;
	
	

	@Autowired
	private PasswordEncoder encoder;

	@PostConstruct
	public void init() throws BadRequestException {

		if (userRepository.findAll().isEmpty()) {
			Right createProductRight = new Right("C_PRODUCT");
			Right createOrderRight = new Right("C_ORDER");
			Right createUserRight = new Right("C_USER");
			Right createBasketRight = new Right ("C_BASKET");

			Right readOrderRight = new Right("R_ORDER");
			Right readProductRight = new Right("R_PRODUCT");
			Right readUserRight = new Right("R_USER");
			Right readBasketRight = new Right("R_BASKET");

			Right updateProductRight = new Right("U_PRODUCT");
			Right updateOrderRight = new Right("U_ORDER");
			Right updateUserRight = new Right("U_USER");
			Right updateBasketRight = new Right("U_BASKET");

			Right deleteProductRight = new Right("D_PRODUCT");
			Right deleteUserRight = new Right("D_USER");
			Right deleteOrderRight = new Right("D_ORDER");
			Right deleteBasketRight = new Right("D_BASKET");

			rightRepository.save(createProductRight);
			rightRepository.save(createOrderRight);
			rightRepository.save(createUserRight);
			rightRepository.save(createBasketRight);

			rightRepository.save(readOrderRight);
			rightRepository.save(readProductRight);
			rightRepository.save(readUserRight);
			rightRepository.save(readBasketRight);

			rightRepository.save(updateProductRight);
			rightRepository.save(updateOrderRight);
			rightRepository.save(updateUserRight);
			rightRepository.save(updateBasketRight);

			rightRepository.save(deleteProductRight);
			rightRepository.save(deleteUserRight);
			rightRepository.save(deleteOrderRight);
			rightRepository.save(deleteBasketRight);

			List<Right> rightsVisitorList = new ArrayList<Right>();
			rightsVisitorList.add(readProductRight);

			List<Right> rightsCustomerList = new ArrayList<Right>();
			rightsCustomerList.addAll(rightsVisitorList);
			rightsCustomerList.add(updateBasketRight);
			rightsCustomerList.add(readOrderRight);

			List<Right> rightsAdminList = new ArrayList<Right>();
			rightsAdminList.addAll(rightsCustomerList);
			rightsAdminList.add(createProductRight);
			rightsAdminList.add(createOrderRight);
			rightsAdminList.add(createUserRight);
			rightsAdminList.add(updateProductRight);

			Role adminRole = new Role("ADMIN");
			adminRole.setRights(rightsAdminList);
			Role customerRole = new Role("CUSTOMER");
			customerRole.setRights(rightsCustomerList);
			Role visitorRole = new Role("VISITOR");
			visitorRole.setRights(rightsVisitorList);

			roleRepository.save(adminRole);
			roleRepository.save(customerRole);
			roleRepository.save(visitorRole);

			User userAdmin = new User("admin@sas.net", encoder.encode("admin"));
			userAdmin.setRole(adminRole);
			User userCustomer = new User("Milton","EUSTACHE","TahitiBob@sas.net", encoder.encode("milton"), "ru de Eustache", 28 , LocalDate.of(1994, 12, 31), "test", "France", "34070", "0635656565");
			userCustomer.setRole(customerRole);

//	//		User userVisitor = new User("visitor", encoder.encode("visitor"), "visitor@sas.net");
//	//		userVisitor.setRole(visitorRole);
//
			userRepository.save(userAdmin);
			userRepository.save(userCustomer);
//	//		userRepository.save(userVisitor);

			/*
			 * String login, String firstName, String lastName, String street, Integer
			 * streetNumber, LocalDate dOB, String password, String city, String country,
			 * String zipCode, String eMail
			 */

			Product product1 = new Product("Iphone", "Pigeon", 500, 10, ProductType.SMARTPHONE, CategoryType.QUOTIDIEN, "06454");
			Product product2 = new Product("GodMichet", "Marc Dorcel", 500, 10, ProductType.SMARTPHONE, CategoryType.QUOTIDIEN, "06454");
			productJpaRepository.save(product1);
			productJpaRepository.save(product2);

			Order orderCustomer= new Order(LocalDate.of(2016, 12, 25), userCustomer);
			List<CommandLine> commandeligne = new ArrayList<CommandLine>();
			
			//	public CommandLine(Integer quantities, Product product, Order order) {

			commandeligne.add(new CommandLine(55, product1, orderCustomer));
			commandeligne.add(new CommandLine(26 , product2, orderCustomer));
			orderCustomer.setCommandLine(commandeligne);
			
			orderRepository.save(orderCustomer);
		}
	}
}
