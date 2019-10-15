package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import fr.projet.domain.Customer;
import fr.projet.domain.criteria.CustomerCriteria;

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

<<<<<<< Updated upstream
	public List<Customer> searchWithCriterias(CustomerCriteria customerCriteria) {
		String qlString = "from Customer c";

		if (customerCriteria.hasCriterias()) {
			qlString += " where 1=1";

			if (!StringUtils.isEmpty(customerCriteria.getLogin())) {
				qlString += " and lower(c.login) like lower(:login)";
			}
			if (!StringUtils.isEmpty(customerCriteria.getFirstName())) {
				qlString += " and lower(c.firstName) like lower(:firstName)";
			}
			if (!StringUtils.isEmpty(customerCriteria.getStreet())) {
				qlString += " and lower (c.lastName) like lower (:lastName)";
			}
			if (!StringUtils.isEmpty(customerCriteria.getStreet())) {
				qlString += " and lower (c.lastName) like lower (:lastName)";
			}
			if (customerCriteria.getStreetNumber() != null) {
				qlString += " and c.streetNumber = :streetNumber";
			}
			if (customerCriteria.getdOB() != null) {
				qlString += " and c.dOB = :dOB";
			}
			if (!StringUtils.isEmpty(customerCriteria.getPassword())) {
				qlString += " and lower (c.password) like lower (:password)";
			}
			if (!StringUtils.isEmpty(customerCriteria.getCity())) {
				qlString += " and lower (c.city) like lower (:city)";
			}
			if (!StringUtils.isEmpty(customerCriteria.getCountry())) {
				qlString += " and lower (c.country) like lower (:country)";
			}
			if (!StringUtils.isEmpty(customerCriteria.getZipCode())) {
				qlString += " and lower (c.zipCode) like lower (:zipCode)";
			}
			if (!StringUtils.isEmpty(customerCriteria.geteMail())) {
				qlString += " and lower (c.eMail) like lower (:eMail)";
			}
			if (!StringUtils.isEmpty(customerCriteria.getPhoneNumber())) {
				qlString += " and lower (c.phoneNumber) like lower (:phoneNumber)";
			}

			
		}

		TypedQuery<Customer> query = entityManager.createQuery(qlString, Customer.class);

		if (customerCriteria.hasCriterias()) {
			if (!StringUtils.isEmpty(customerCriteria.getLogin())) {
				query.setParameter("login", "%" + customerCriteria.getLogin() + "%");
			}
			if (!StringUtils.isEmpty(customerCriteria.getFirstName())) {
				query.setParameter("firstName", "%" + customerCriteria.getFirstName() + "%");
			}
			if (!StringUtils.isEmpty(customerCriteria.getLastName())) {
				query.setParameter("lastName", "%" + customerCriteria.getLastName() + "%");
			}

			if (!StringUtils.isEmpty(customerCriteria.getStreet())) {
				query.setParameter("street", "%" + customerCriteria.getStreet() + "%");

			}
			if (customerCriteria.getStreetNumber() != null) {
				query.setParameter("streetNumber", customerCriteria.getStreetNumber());
			}
		
			if (customerCriteria.getdOB() != null) {
				query.setParameter("dOB", customerCriteria.getdOB());
			}
			if (!StringUtils.isEmpty(customerCriteria.getPassword())) {
				query.setParameter("password", "%" + customerCriteria.getPassword() + "%");

			}
			if (!StringUtils.isEmpty(customerCriteria.getCity())) {
				query.setParameter("city", "%" + customerCriteria.getCity() + "%");

			}
			if (!StringUtils.isEmpty(customerCriteria.getCountry())) {
				query.setParameter("country", "%" + customerCriteria.getCountry() + "%");

			}
			if (!StringUtils.isEmpty(customerCriteria.getZipCode())) {
				query.setParameter("zipCode", "%" + customerCriteria.getStreet() + "%");

			}
			if (!StringUtils.isEmpty(customerCriteria.geteMail())) {
				query.setParameter("eMail", "%" + customerCriteria.geteMail() + "%");

			}
			if (!StringUtils.isEmpty(customerCriteria.getPhoneNumber())) {
				query.setParameter("phoneNumber", "%" + customerCriteria.getPhoneNumber() + "%");

			}
		}

		return query.getResultList();
	}

	public List<Customer> searchWithCriteria(CustomerCriteria customerCriteria) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
		Root<Customer> root = criteria.from(Customer.class);

		if (!StringUtils.isEmpty(customerCriteria.getLogin())) {
			criteria.where(builder.like(root.get("login"), "%" + customerCriteria.getLogin() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.getFirstName())) {
			criteria.where(builder.like(root.get("firstName"), "%" + customerCriteria.getFirstName() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.getLastName())) {
			criteria.where(builder.like(root.get("lastName"), "%" + customerCriteria.getLastName() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.getStreet())) {
			criteria.where(builder.like(root.get("street"), "%" + customerCriteria.getStreet() + "%"));
		}
		if (customerCriteria.getStreetNumber() != null) {
			criteria.where(builder.like(root.get("streetNumber"), "%" + customerCriteria.getStreetNumber() + "%"));
		}
		if (customerCriteria.getdOB() != null) {
			criteria.where(builder.like(root.get("dOB"), "%" + customerCriteria.getdOB() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.getPassword())) {
			criteria.where(builder.like(root.get("password"), "%" + customerCriteria.getPassword() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.getCity())) {
			criteria.where(builder.like(root.get("city"), "%" + customerCriteria.getCity() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.getCountry())) {
			criteria.where(builder.like(root.get("country"), "%" + customerCriteria.getCountry() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.getZipCode())) {
			criteria.where(builder.like(root.get("zipCode"), "%" + customerCriteria.getZipCode() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.geteMail())) {
			criteria.where(builder.like(root.get("eMail"), "%" + customerCriteria.geteMail() + "%"));
		}
		if (!StringUtils.isEmpty(customerCriteria.getPhoneNumber())) {
			criteria.where(builder.like(root.get("phoneNumber"), "%" + customerCriteria.getPhoneNumber() + "%"));
		}
		
		
		

		List<Customer> customers = entityManager.createQuery(criteria).getResultList();

		return customers;
=======
	public Customer findOneByEmail(String email) {
		String qlString = "from Customer u where u.email = :email";
		TypedQuery<Customer> query = entityManager.createQuery(qlString, Customer.class);
		query.setParameter("email", email);
		
		return query.getSingleResult();
>>>>>>> Stashed changes
	}
}
