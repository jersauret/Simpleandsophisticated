package fr.projet.domain;

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

@Entity
@Table(name = "order_")
public class Order implements IoEntity {

	private static final long serialVersionUID = -3737508893634026566L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime purchaseDate;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER/* cascade = { CascadeType.REMOVE, CascadeType.MERGE}*/)
	private List<CommandLine> commandLine;

	@ManyToOne
	private Customer customer;

	public Order() {
	}

	public Order(LocalDateTime purchaseDate, List<CommandLine> commandLine, Customer customer) {
		super();
		this.purchaseDate =purchaseDate;
		
		this.commandLine = commandLine;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
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

}
