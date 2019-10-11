package fr.projet.domain;



public class User{
	
	private String login;
	private String firstName;
	private String lastName;
	private String password;
	
	public User() {
		
	}

	public User(String login, String firstName, String lastName, String password) {
		
		this.login = login;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}