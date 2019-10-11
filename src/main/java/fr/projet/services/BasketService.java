package fr.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.Basket;
import fr.projet.exception.BadRequestException;
import fr.projet.repository.BasketJpaRepository;

@Service
@Transactional
public class BasketService {

	@Autowired
	private BasketJpaRepository basketRepository;	
	
	public Basket find(Long id) {
		return basketRepository.find(id);
	}
	
	
	public List<Basket> findAll() {
		return basketRepository.findAll();
	}
	
	@Transactional(readOnly = false)
	public Basket save(Basket basket) throws BadRequestException {
		try {
			return basketRepository.save(basket);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Basket cannot be created with an id.", e);
		}
	}
	
	public Basket update(Basket basket) {
		return basketRepository.update(basket);
	}
	
	public Basket delete(Long id) {
		return basketRepository.delete(id);
	}
}
