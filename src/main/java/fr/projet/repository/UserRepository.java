package fr.projet.repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.projet.domain.User;

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

}
