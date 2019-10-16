//package fr.projet.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.InvalidDataAccessApiUsageException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import fr.projet.domain.Customer;
//import fr.projet.domain.criteria.CustomerCriteria;
//import fr.projet.exception.BadRequestException;
//import fr.projet.repository.CustomerJpaRepository;
//
//@Service
//@Transactional
//public class CustomerService {
//
//	@Autowired
//	private CustomerJpaRepository customerJpaRepository;
//
//	public Customer find(Long id) {
//		return customerJpaRepository.find(id);
//	}
//
//	public List<Customer> findAll() {
//		return customerJpaRepository.findAll();
//	}
//
//	@Transactional(readOnly = false)
//	public Customer save(Customer customer) throws BadRequestException {
//		try {
//			return customerJpaRepository.save(customer);
//		} catch (InvalidDataAccessApiUsageException e) {
//			throw new BadRequestException("User cannot be created with an id.", e);
//		}
//	}
//
//	public Customer update(Customer customer) {
//		return customerJpaRepository.update(customer);
//	}
//
//	public Customer delete(Long id) {
//		return customerJpaRepository.delete(id);
//	}
//
//	public List<Customer> search(CustomerCriteria criteria) {
//		return customerJpaRepository.searchWithCriteria(criteria);
//	}
//
//	public Customer findOneByEmail(String email) {
//		return customerJpaRepository.findOneByEmail(email);
//	}
//
//}
