package fr.projet.domain.criteria;

import java.time.LocalDate;

import org.springframework.util.StringUtils;

public class CustomerCriteria {
	private String login;
	private String firstName;
	private String lastName;
	private String street;
	private Integer streetNumber;
	private LocalDate dOB;
	private String password;
	private String city;
	private String country;
	private String zipCode; // Code Postal
	private String eMail;
	private String phoneNumber;

	
	
	public CustomerCriteria(String login, String firstName, String lastName, String street, Integer streetNumber,
			LocalDate dOB, String password, String city, String country, String zipCode, String eMail,
			String phoneNumber) {
		super();
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.streetNumber = streetNumber;
		this.dOB = dOB;
		this.password = password;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
		this.eMail = eMail;
		this.phoneNumber = phoneNumber;
	}

	public boolean hasCriterias() {
		return !StringUtils.isEmpty(login) || !StringUtils.isEmpty(firstName) || !StringUtils.isEmpty(lastName) ||!StringUtils.isEmpty(street) 
				|| streetNumber !=null || dOB !=null || StringUtils.isEmpty(password) || StringUtils.isEmpty(city) || StringUtils.isEmpty(country)
				|| StringUtils.isEmpty(zipCode) || StringUtils.isEmpty(eMail) || StringUtils.isEmpty(phoneNumber); 
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	public LocalDate getdOB() {
		return dOB;
	}

	public void setdOB(LocalDate dOB) {
		this.dOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

}
