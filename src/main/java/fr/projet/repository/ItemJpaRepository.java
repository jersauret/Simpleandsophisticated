package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import fr.projet.domain.Product;
import fr.projet.domain.criteria.ItemCriteria;

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

	public List<Product> search(ItemCriteria criteria) {
		String qlString = "from Product p";

		if (criteria.hasCriterias()) {
			qlString += " where 1=1";

			if (!StringUtils.isEmpty(criteria.getName())) {
				qlString += " and lower(p.name) like lower(:name)";
			}
			if (!StringUtils.isEmpty(criteria.getSupplier())) {
				qlString += " and lower(p.supplier) like lower(:supplier)";
			}
			if (criteria.getRetailPriceMin() != null) {
				qlString += " and p.retailPrice >= :retailPriceMin";
			}
			// TODO: Etc.
		}

		TypedQuery<Product> query = entityManager.createQuery(qlString, Product.class);

		if (criteria.hasCriterias()) {
			if (!StringUtils.isEmpty(criteria.getName())) {
				query.setParameter("name", "%" + criteria.getName() + "%");
			}
			if (!StringUtils.isEmpty(criteria.getSupplier())) {
				query.setParameter("supplier", "%" + criteria.getSupplier() + "%");
			}
			if (criteria.getRetailPriceMin() != null) {
				query.setParameter("retailPriceMin", criteria.getRetailPriceMin());
			}
		}

		return query.getResultList();
	}

	public List<Product> searchWithCriteria(ItemCriteria itemCritera) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
		Root<Product> root = criteria.from(Product.class);
		
		if (!StringUtils.isEmpty(itemCritera.getName())) {
			criteria.where(builder.like(root.get("name"), "%" + itemCritera.getName() + "%"));
		}
		if (!StringUtils.isEmpty(itemCritera.getSupplier())) {
			criteria.where(builder.like(root.get("supplier"), "%" + itemCritera.getSupplier() + "%"));
		}
		// TODO: Etc.;

		List<Product> products = entityManager.createQuery(criteria).getResultList();
		
		return products;
	}
}
