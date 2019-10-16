package fr.projet.domain.criteria;

import java.time.LocalDate;

import org.springframework.util.StringUtils;

public class UserCriteria {

		private Long id;

		private String email;
		
		private String firstName;
		private String lastName;
		private String password;
		private String street;
		private Integer streetNumber;
		private LocalDate dOB;
		private String city;
		private String country;
		private String zipCode; // Code Postal
		private String eMail;
		private String phoneNumber;

		// CONSTRUCTEUR ADMIN
		public UserCriteria(String eMail, String password, String firstName, String lastName) {
			super();
			this.eMail = eMail;
			
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			
		}
		
		// CONSTRUCTEUR CLIENT
		public UserCriteria(String email, String firstName, String lastName, String password, String street, Integer streetNumber, LocalDate dOB,
				String city, String country, String zipCode, String phoneNumber) {
			super();
			this.email = email;
			
			this.password = password;
			this.street = street;
			this.streetNumber = streetNumber;
			this.dOB = dOB;
			this.city = city;
			this.country = country;
			this.zipCode = zipCode;
			this.phoneNumber = phoneNumber;
			this.firstName = firstName;
			this.lastName = lastName;
		
		}

		public UserCriteria() {
		}
		
		public boolean hasCriterias() {
			return !StringUtils.isEmpty(firstName) || !StringUtils.isEmpty(lastName) ||!StringUtils.isEmpty(street) 
					|| streetNumber !=null || dOB !=null || StringUtils.isEmpty(password) || StringUtils.isEmpty(city) || StringUtils.isEmpty(country)
					|| StringUtils.isEmpty(zipCode) || StringUtils.isEmpty(eMail) || StringUtils.isEmpty(phoneNumber); 
		}

		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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
