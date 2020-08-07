package src.main.java.net.javaguides.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class the defines the role of the user
 * @author QuestionBankGroup
 *
 */
@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

/**
 * Default constructor for Role class
 */
	public Role() {
		
	}

/**
 * Constructor for Role object
 * @param name the user name
 */
	public Role(String name) {
		super();
		this.name = name;
	}

/**
 * Get method for role id
 * @return the role id
 */
	public Long getId() {
		return id;
	}
	
/**
 * Set method for role id
 * @param id the id for the role
 */
	public void setId(Long id) {
		this.id = id;
	}
	
/**
 * Get method for the role name
 * @return the role name
 */
	public String getName() {
		return name;
	}
	
/**
 * Set method for role name
 * @param name the role name
 */
	public void setName(String name) {
		this.name = name;
	}
}
