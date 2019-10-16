//package fr.projet.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "administrator_")
//public class Admin implements IdEntity {
//
//	private static final long serialVersionUID = 7888330938934821980L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String login;
//	private String firstName;
//	private String lastName;
//	private String eMail;
//	private String password;
//	
//	public Admin() {
//		
//	}
//
//	public Admin(Long id, String login, String firstName, String lastName, String eMail, String password) {
//		super();
//		this.id = id;
//		this.login = login;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.eMail = eMail;
//		this.password = password;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getLogin() {
//		return login;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String geteMail() {
//		return eMail;
//	}
//
//	public void seteMail(String eMail) {
//		this.eMail = eMail;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	
//
//}
//
