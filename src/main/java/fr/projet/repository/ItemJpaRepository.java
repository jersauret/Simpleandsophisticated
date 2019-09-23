package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Product;

@Repository
@Transactional
public class ItemJpaRepository extends AbstractJpaRepository<Product> {

	public ItemJpaRepository() {
		super(Product.class);
	}
	
	public Product findOneByLogin(String login) {
		String qlString = "from Item u where u.login = :login";
		TypedQuery<Product> query = entityManager.createQuery(qlString, Product.class);
		query.setParameter("login", login);
		
		return query.getSingleResult();
	}

	public List<Product> findByName(String name) {
		String qlString = "from Product u where u.name = :name";
		TypedQuery<Product> query = entityManager.createQuery(qlString, Product.class);
		query.setParameter("name", name);
		
		return query.getResultList();
	}
}
