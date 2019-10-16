 package fr.projet.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "user_")
public class User implements IdEntity {

	private static final long serialVersionUID = 1567072496732951021L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	
	private String password;
	private String street;
	private Integer streetNumber;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dOB;
	private String city;
	private String country;
	private String zipCode; // Code Postal
	private String eMail;
	private String phoneNumber;
	
	
	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy = "user")
	private List<Order> order;

	//CONSTRUCTEUR ADMIN
	public User(String eMail, String password) {
		super();
		this.eMail = eMail;
		this.password = password;
		
	}
	
	// CONSTRUCTEUR CLIENT
	public User(String email,  String password, String street, Integer streetNumber, LocalDate dOB,
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
		
	}


	public User() {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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


	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}

}
