package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import fr.projet.domain.Admin;
import fr.projet.domain.Customer;
import fr.projet.domain.criteria.AdminCriteria;
import fr.projet.domain.criteria.CustomerCriteria;

@Repository
@Transactional
public class AdminJpaRepository extends AbstractJpaRepository<Admin> {
	public AdminJpaRepository() {
		super(Admin.class);
	}
	
	public Admin findOneByLogin(String login) {
		String qlString = "from Admin u where u.login = :login";
		TypedQuery<Admin> query = entityManager.createQuery(qlString, Admin.class);
		query.setParameter("login", login);
		
		return query.getSingleResult();
	}
	public List<Admin> search(AdminCriteria adminCriteria) {
		String qlString = "from Customer c";

		if (adminCriteria.hasCriterias()) {
			qlString += " where 1=1";

			if (!StringUtils.isEmpty(adminCriteria.getLogin())) {
				qlString += " and lower(c.login) like lower(:login)";
			}
			if (!StringUtils.isEmpty(adminCriteria.getFirstName())) {
				qlString += " and lower(c.firstName) like lower(:firstName)";
			}
			
			if (!StringUtils.isEmpty(adminCriteria.getPassword())) {
				qlString += " and lower (c.password) like lower (:password)";
			}
			
			
			if (!StringUtils.isEmpty(adminCriteria.geteMail())) {
				qlString += " and lower (c.eMail) like lower (:eMail)";
			}
			

			
		}

		TypedQuery<Admin> query = entityManager.createQuery(qlString, Admin.class);

		if (adminCriteria.hasCriterias()) {
			if (!StringUtils.isEmpty(adminCriteria.getLogin())) {
				query.setParameter("login", "%" + adminCriteria.getLogin() + "%");
			}
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

	public List<Admin> searchWithCriteria(AdminCriteria adminCriteria) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Admin> criteria = builder.createQuery(Admin.class);
		Root<Admin> root = criteria.from(Admin.class);

		if (!StringUtils.isEmpty(adminCriteria.getLogin())) {
			criteria.where(builder.like(root.get("login"), "%" + adminCriteria.getLogin() + "%"));
		}
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
		
		
		
		

		List<Admin> admins = entityManager.createQuery(criteria).getResultList();

		return admins;
	}
}
