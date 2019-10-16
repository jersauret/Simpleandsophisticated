package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import fr.projet.domain.User;
import fr.projet.domain.criteria.UserCriteria;

@Repository
@Transactional
public class UserRepository extends AbstractJpaRepository<User>{

	public UserRepository() {
		super(User.class);
	}

	public User findOneByEmail(String email) {
		//TODO: Récupérer depuis la base (penser à fetch les roles et droits)
		String qlQuery = "from User u left join fetch u.role r left join fetch r.rights where u.email = :email";
		TypedQuery<User> query = entityManager.createQuery(qlQuery, User.class);
		query.setParameter("email", email);
		
		return query.getSingleResult();
	}
	
	//RECHERCHE MULTICRITERES CLIENTS 
	public List<User> searchClient(UserCriteria userCriteria) {
		String qlString = "from User u";

		if (userCriteria.hasCriterias()) {
			qlString += " where 1=1";

			
			if (!StringUtils.isEmpty(userCriteria.getFirstName())) {
				qlString += " and lower(u.firstName) like lower(:firstName)";
			}
			if (!StringUtils.isEmpty(userCriteria.getStreet())) {
				qlString += " and lower (u.lastName) like lower (:lastName)";
			}
			if (!StringUtils.isEmpty(userCriteria.getStreet())) {
				qlString += " and lower (u.lastName) like lower (:lastName)";
			}
			if (userCriteria.getStreetNumber() != null) {
				qlString += " and u.streetNumber = :streetNumber";
			}
			if (userCriteria.getdOB() != null) {
				qlString += " and u.dOB = :dOB";
			}
			if (!StringUtils.isEmpty(userCriteria.getPassword())) {
				qlString += " and lower (u.password) like lower (:password)";
			}
			if (!StringUtils.isEmpty(userCriteria.getCity())) {
				qlString += " and lower (u.city) like lower (:city)";
			}
			if (!StringUtils.isEmpty(userCriteria.getCountry())) {
				qlString += " and lower (u.country) like lower (:country)";
			}
			if (!StringUtils.isEmpty(userCriteria.getZipCode())) {
				qlString += " and lower (u.zipCode) like lower (:zipCode)";
			}
			if (!StringUtils.isEmpty(userCriteria.geteMail())) {
				qlString += " and lower (u.eMail) like lower (:eMail)";
			}
			if (!StringUtils.isEmpty(userCriteria.getPhoneNumber())) {
				qlString += " and lower (u.phoneNumber) like lower (:phoneNumber)";
			}

			
		}

		TypedQuery<User> query = entityManager.createQuery(qlString, User.class);

		if (userCriteria.hasCriterias()) {
			
			if (!StringUtils.isEmpty(userCriteria.getFirstName())) {
				query.setParameter("firstName", "%" + userCriteria.getFirstName() + "%");
			}
			if (!StringUtils.isEmpty(userCriteria.getLastName())) {
				query.setParameter("lastName", "%" + userCriteria.getLastName() + "%");
			}

			if (!StringUtils.isEmpty(userCriteria.getStreet())) {
				query.setParameter("street", "%" + userCriteria.getStreet() + "%");

			}
			if (userCriteria.getStreetNumber() != null) {
				query.setParameter("streetNumber", userCriteria.getStreetNumber());
			}
		
			if (userCriteria.getdOB() != null) {
				query.setParameter("dOB", userCriteria.getdOB());
			}
			if (!StringUtils.isEmpty(userCriteria.getPassword())) {
				query.setParameter("password", "%" + userCriteria.getPassword() + "%");

			}
			if (!StringUtils.isEmpty(userCriteria.getCity())) {
				query.setParameter("city", "%" + userCriteria.getCity() + "%");

			}
			if (!StringUtils.isEmpty(userCriteria.getCountry())) {
				query.setParameter("country", "%" + userCriteria.getCountry() + "%");

			}
			if (!StringUtils.isEmpty(userCriteria.getZipCode())) {
				query.setParameter("zipCode", "%" + userCriteria.getStreet() + "%");

			}
			if (!StringUtils.isEmpty(userCriteria.geteMail())) {
				query.setParameter("eMail", "%" + userCriteria.geteMail() + "%");

			}
			if (!StringUtils.isEmpty(userCriteria.getPhoneNumber())) {
				query.setParameter("phoneNumber", "%" + userCriteria.getPhoneNumber() + "%");

			}
		}

		return query.getResultList();
	}

	public List<User> searchClientWithCriteria(UserCriteria userCriteria) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);

		
		if (!StringUtils.isEmpty(userCriteria.getFirstName())) {
			criteria.where(builder.like(root.get("firstName"), "%" + userCriteria.getFirstName() + "%"));
		}
		if (!StringUtils.isEmpty(userCriteria.getLastName())) {
			criteria.where(builder.like(root.get("lastName"), "%" + userCriteria.getLastName() + "%"));
		}
		if (!StringUtils.isEmpty(userCriteria.getStreet())) {
			criteria.where(builder.like(root.get("street"), "%" + userCriteria.getStreet() + "%"));
		}
		if (userCriteria.getStreetNumber() != null) {
			criteria.where(builder.like(root.get("streetNumber"), "%" + userCriteria.getStreetNumber() + "%"));
		}
		if (userCriteria.getdOB() != null) {
			criteria.where(builder.like(root.get("dOB"), "%" + userCriteria.getdOB() + "%"));
		}
		if (!StringUtils.isEmpty(userCriteria.getPassword())) {
			criteria.where(builder.like(root.get("password"), "%" + userCriteria.getPassword() + "%"));
		}
		if (!StringUtils.isEmpty(userCriteria.getCity())) {
			criteria.where(builder.like(root.get("city"), "%" + userCriteria.getCity() + "%"));
		}
		if (!StringUtils.isEmpty(userCriteria.getCountry())) {
			criteria.where(builder.like(root.get("country"), "%" + userCriteria.getCountry() + "%"));
		}
		if (!StringUtils.isEmpty(userCriteria.getZipCode())) {
			criteria.where(builder.like(root.get("zipCode"), "%" + userCriteria.getZipCode() + "%"));
		}
		if (!StringUtils.isEmpty(userCriteria.geteMail())) {
			criteria.where(builder.like(root.get("eMail"), "%" + userCriteria.geteMail() + "%"));
		}
		if (!StringUtils.isEmpty(userCriteria.getPhoneNumber())) {
			criteria.where(builder.like(root.get("phoneNumber"), "%" + userCriteria.getPhoneNumber() + "%"));
		}
		
		
		

		List<User> customers = entityManager.createQuery(criteria).getResultList();

		return customers;
	}
	
	//RECHERCHE MULTICRITERES ADMIN
	public List<User> searchAdmin(UserCriteria adminCriteria) {
		String qlString = "from user u ";

		if (adminCriteria.hasCriterias()) {
			qlString += " where 1=1";

			
			if (!StringUtils.isEmpty(adminCriteria.getFirstName())) {
				qlString += " and lower(u.firstName) like lower(:firstName)";
			}
			
			if (!StringUtils.isEmpty(adminCriteria.getPassword())) {
				qlString += " and lower (u.password) like lower (:password)";
			}
			
			
			if (!StringUtils.isEmpty(adminCriteria.geteMail())) {
				qlString += " and lower (u.eMail) like lower (:eMail)";
			}
			

			
		}

		TypedQuery<User> query = entityManager.createQuery(qlString, User.class);

		if (adminCriteria.hasCriterias()) {
			
			if (!StringUtils.isEmpty(adminCriteria.getFirstName())) {
				query.setParameter("firstName", "%" + adminCriteria.getFirstName() + "%");
			}
			if (!StringUtils.isEmpty(adminCriteria.getLastName())) {
				query.setParameter("lastName", "%" + adminCriteria.getLastName() + "%");
			}


			if (!StringUtils.isEmpty(adminCriteria.getPassword())) {
				query.setParameter("password", "%" + adminCriteria.getPassword() + "%");

			}
			
			if (!StringUtils.isEmpty(adminCriteria.geteMail())) {
				query.setParameter("eMail", "%" + adminCriteria.geteMail() + "%");

			}
		}

		return query.getResultList();
	}

	public List<User> searchAdminWithCriteria(UserCriteria adminCriteria) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);

		
		if (!StringUtils.isEmpty(adminCriteria.getFirstName())) {
			criteria.where(builder.like(root.get("firstName"), "%" + adminCriteria.getFirstName() + "%"));
		}
		if (!StringUtils.isEmpty(adminCriteria.getLastName())) {
			criteria.where(builder.like(root.get("lastName"), "%" + adminCriteria.getLastName() + "%"));
		}
		
		if (!StringUtils.isEmpty(adminCriteria.getPassword())) {
			criteria.where(builder.like(root.get("password"), "%" + adminCriteria.getPassword() + "%"));
		}
		
		if (!StringUtils.isEmpty(adminCriteria.geteMail())) {
			criteria.where(builder.like(root.get("eMail"), "%" + adminCriteria.geteMail() + "%"));
		}
		
		
		
		

		List<User> admins = entityManager.createQuery(criteria).getResultList();

		return admins;
	}

}
