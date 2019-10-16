package fr.projet.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.projet.domain.Role;
import fr.projet.domain.User;
import fr.projet.repository.UserRepository;

@Component
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		User user = userRepository.findOneByEmail(username);
		if (user != null) {
			List<GrantedAuthority> rules = this.getUserCredentials(user);
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), rules);
		}
		throw new UsernameNotFoundException("username.not.found");
	}

	private List<GrantedAuthority> getUserCredentials(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		Role role = user.getRole();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		role.getRights().forEach(right -> authorities.add(new SimpleGrantedAuthority(right.getRightName())));
		
		return authorities;
	}
}
