//package fr.projet.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.InvalidDataAccessApiUsageException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import fr.projet.domain.Admin;
//import fr.projet.domain.criteria.AdminCriteria;
//import fr.projet.exception.BadRequestException;
//import fr.projet.repository.AdminJpaRepository;
//
//@Service
//@Transactional
//public class AdminService {
//
//	@Autowired
//	private AdminJpaRepository adminRepository;	
//	
//	public Admin find(Long id) {
//		return adminRepository.find(id);
//	}
//	
//	public Admin findOneByLogin(String login) {
//		return adminRepository.findOneByLogin(login);
//	}
//	
//	public List<Admin> findAll() {
//		return adminRepository.findAll();
//	}
//	
//	
//	@Transactional(readOnly = false)
//	public Admin save(Admin admin) throws BadRequestException {
//		try {
//			return adminRepository.save(admin);
//		} catch (InvalidDataAccessApiUsageException e) {
//			throw new BadRequestException("Admin cannot be created with an id.", e);
//		}
//	}
//	
//	public Admin update(Admin admin) {
//		return adminRepository.update(admin);
//	}
//	
//	public Admin delete(Long id) {
//		return adminRepository.delete(id);
//	}
//	
//	public List <Admin> search(AdminCriteria criteria){
//		return adminRepository.searchWithCriteria(criteria);
//	}
//}
