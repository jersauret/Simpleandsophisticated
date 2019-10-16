package fr.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import fr.projet.domain.User;

@Service
public class SecurityService {
	
	@Autowired
	private UserService userService;

	public boolean isConnectedUser(long userId) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			User user = userService.find(userId);
			
			return user.getEmail().equals(userDetails.getUsername());
			
		} catch (Exception e) {
			return false;
		}
	}
}
