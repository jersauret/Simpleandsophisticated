package fr.projet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "right_")
public class Right implements IdEntity {
	
	private static final long serialVersionUID = -5553986287253127324L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rightName;
	
//	@ManyToMany(mappedBy = "rights", fetch = FetchType.LAZY, cascade = { CascadeType.ALL, CascadeType.REMOVE, CascadeType.PERSIST })
//	private List<Role> roles;
	
	public Right(String rightName) {
		this.rightName = rightName;
	}
	
	public Right() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}


//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}
	
}
