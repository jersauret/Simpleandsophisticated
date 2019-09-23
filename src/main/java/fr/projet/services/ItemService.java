package fr.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Product;
import fr.projet.exception.BadRequestException;
import fr.projet.repository.ItemJpaRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemJpaRepository itemRepository;	
	
	public Product find(Long id) {
		return itemRepository.find(id);
	}
	
	public Product findOneByLogin(String login) {
		return itemRepository.findOneByLogin(login);
	}
	
	public List<Product> findAll() {
		return itemRepository.findAll();
	}
	
	@Transactional(readOnly = false)
	public Product save(Product user) throws BadRequestException {
		try {
			return itemRepository.save(user);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Item cannot be created with an id.", e);
		}
	}
	
	public Product update(Product item) {
		return itemRepository.update(item);
	}
	
	public Product delete(Long id) {
		return itemRepository.delete(id);
	}
}
