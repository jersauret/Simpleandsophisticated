package fr.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Product;
import fr.projet.domain.criteria.ProductCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.repository.ProductJpaRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductJpaRepository productRepository;	
	
	public Product find(Long id) {
		return productRepository.find(id);
	}
	
//	public Product findOneByName(String name) {
//		return productRepository.findByName(name);
//	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Transactional(readOnly = false)
	public Product save(Product user) throws BadRequestException {
		try {
			return productRepository.save(user);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Item cannot be created with an id.", e);
		}
	}
	
	public Product update(Product item) {
		return productRepository.update(item);
	}
	
	public Product delete(Long id) {
		return productRepository.delete(id);
	}

	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
		
	}

	public List<Product> search(ProductCriteria criteria) {
		return productRepository.search(criteria);
	}
}
