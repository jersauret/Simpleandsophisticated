package fr.projet.repository;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Admin;

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
}
