package fr.projet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "order_")
public class Order implements IoEntity {

	private static final long serialVersionUID = -3737508893634026566L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate purchaseDate;
	private Integer orderNumber;
	private Integer totalPrice;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = { CascadeType.ALL, CascadeType.REMOVE,
			CascadeType.PERSIST })
	private List<CommandLine> commandLine;

	@ManyToOne
	private Customer customer;

	public Order() {
	}

	public Order(LocalDate purchaseDate, Integer orderNumber, Integer totalPrice, List<CommandLine> commandLine,
			Customer customer) {
		super();
		this.purchaseDate = purchaseDate;
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
		this.commandLine = commandLine;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<CommandLine> getCommandLine() {
		return commandLine;
	}

	public void setCommandLine(List<CommandLine> commandLine) {
		this.commandLine = commandLine;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
