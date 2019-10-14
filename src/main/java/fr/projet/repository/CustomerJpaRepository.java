package fr.projet.repository;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Customer;

@Repository
@Transactional
public class CustomerJpaRepository extends AbstractJpaRepository<Customer> {

	public CustomerJpaRepository() {
		super(Customer.class);
	}
	
	public Customer findOneByLogin(String login) {
		String qlString = "from Customer u where u.login = :login";
		TypedQuery<Customer> query = entityManager.createQuery(qlString, Customer.class);
		query.setParameter("login", login);
		
		return query.getSingleResult();
	}
}
