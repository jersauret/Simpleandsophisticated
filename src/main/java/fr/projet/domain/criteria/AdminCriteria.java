package fr.projet.domain.criteria;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class AdminCriteria {

	private Long id;
	private String login;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;


	public AdminCriteria(String login, String firstName, String lastName, String eMail, String password) {
		super();
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
	}
	
	public AdminCriteria() {
		
	}
	
	public boolean hasCriterias() {
		return !StringUtils.isEmpty(login) || !StringUtils.isEmpty(firstName) || !StringUtils.isEmpty(lastName) || StringUtils.isEmpty(eMail) 
				|| StringUtils.isEmpty(password);
				
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}
