package fr.projet.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import fr.projet.domain.Product;
import fr.projet.domain.criteria.ProductCriteria;

@Repository
@Transactional
public class ProductJpaRepository extends AbstractJpaRepository<Product> {

	public ProductJpaRepository() {
		super(Product.class);
	}


	public List<Product> findByName(String name) {
		String qlString = "from Product p where p.name = :name";
		TypedQuery<Product> query = entityManager.createQuery(qlString, Product.class);
		query.setParameter("name", name);

		return query.getResultList();
	}

	public List<Product> search(ProductCriteria criteria) {
		String qlString = "from Product p";

		if (criteria.hasCriterias()) {
			qlString += " where 1=1";
			


			if (!StringUtils.isEmpty(criteria.getName())) {
				qlString += " and lower(p.name) like lower(:name)";
			}
			if (!StringUtils.isEmpty(criteria.getReference())) {
				qlString += " and lower(p.reference) like lower(:reference)";
			}
			if (!StringUtils.isEmpty(criteria.getSupplier())) {
				qlString += " and lower(p.supplier) like lower(:supplier)";
			}
			if (criteria.getRetailPriceMin() != null) {
				qlString += " and p.retailPrice >= :retailPriceMin";
			}
			if (criteria.getRetailPriceMax() != null) {
				qlString += " and p.retailPrice <= :retailPriceMax";
			}
			if (criteria.getStockLevel() != null) {
				if (criteria.getStockLevel().getMin() != null) {
					qlString += " and p.stock >= :minLevel";
				}
				if (criteria.getStockLevel().getMax() != null) {
					qlString += " and p.stock <= :maxLevel";
				}
			}
			if (criteria.getProductType() != null) {
				qlString += " and p.productType like :productTypeSearched";
			}
			if (criteria.getCategory() != null) {
				qlString += " and p.categoryType like :categoryTypeSearched";
			}
			if(criteria.getId() != null) {
				qlString += "and p.id = :id";
			}

		}

		TypedQuery<Product> query = entityManager.createQuery(qlString, Product.class);

		if (criteria.hasCriterias()) {
			if (!StringUtils.isEmpty(criteria.getName())) {
				query.setParameter("name", "%" + criteria.getName() + "%");
			}
			if (!StringUtils.isEmpty(criteria.getSupplier())) {
				query.setParameter("supplier", "%" + criteria.getSupplier() + "%");
			}
			if (!StringUtils.isEmpty(criteria.getReference())) {
				query.setParameter("reference", "%" + criteria.getReference() + "%");
			}
			if (criteria.getRetailPriceMin() != null) {
				query.setParameter("retailPriceMin", criteria.getRetailPriceMin());
			}
			if (criteria.getId() != null) {
				query.setParameter("id", criteria.getId());
			}
			if (criteria.getRetailPriceMax() != null) {
				query.setParameter("retailPriceMax", criteria.getRetailPriceMax());
			}

			if (criteria.getStockLevel() != null) {
				if (criteria.getStockLevel().getMin() != null) {
					query.setParameter("minLevel", criteria.getStockLevel().getMin());
				}
				if (criteria.getStockLevel().getMax() != null) {
					query.setParameter("maxLevel", criteria.getStockLevel().getMax());
				}
			}

			if (criteria.getCategory() != null) {
				query.setParameter("categoryTypeSearched", criteria.getCategory());
			}

			if (criteria.getProductType() != null) {
				query.setParameter("productTypeSearched", criteria.getProductType());
			}

		}

		return query.getResultList();
	}

	/*
	 * public List<Product> searchWithCriteria(ProductCriteria itemCritera) {
	 * CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	 * 
	 * CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
	 * Root<Product> root = criteria.from(Product.class);
	 * 
	 * if (!StringUtils.isEmpty(itemCritera.getName())) {
	 * criteria.where(builder.like(root.get("name"), "%" + itemCritera.getName() +
	 * "%")); } if (!StringUtils.isEmpty(itemCritera.getSupplier())) {
	 * criteria.where(builder.like(root.get("supplier"), "%" +
	 * itemCritera.getSupplier() + "%")); } // TODO: Etc.;
	 * 
	 * List<Product> products = entityManager.createQuery(criteria).getResultList();
	 * 
	 * return products; }
	 */
}
