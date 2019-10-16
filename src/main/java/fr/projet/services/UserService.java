package fr.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.domain.User;
import fr.projet.domain.criteria.UserCriteria;
import fr.projet.exception.BadRequestException;
import fr.projet.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;	
	
	public User find(Long id) {
		return userRepository.find(id);
	}
	
	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional(readOnly = false)
	public User save(User user) throws BadRequestException {
		try {
			return userRepository.save(user);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("User cannot be created with an id.", e);
		}
	}
	
	public User update(User user) {
		return userRepository.update(user);
	}
	
	public User delete(Long id) {
		return userRepository.delete(id);
	}
	public List<User> searchClient(UserCriteria clientCriteria) {
		return userRepository.searchClientWithCriteria(clientCriteria);
	}
	public List<User> searchAdmin(UserCriteria adminCriteria) {
		return userRepository.searchAdminWithCriteria(adminCriteria);
	}
}

