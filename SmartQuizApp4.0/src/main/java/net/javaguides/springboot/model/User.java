package net.javaguides.springboot.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

/**
 * Class that holds user information for the application
 * @author QuestionBankGroup
 * @param id the user id
 * 
* @param firstName the user first name
 * @param lastName the user last name
 * @param email the user email address
 * @param password the user password (stored encrypted in the database)
 * @param period the user class period
 * @param roles a collection of user roles
 *
 */
@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String period;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))
	
	private Collection<Role> roles;
	
/**
 * Default constructor for User object	
 */
	public User() {
		
	}
	
/**
 * Constructor for User object
 * @param firstName the user first name
 * @param lastName the user last name
 * @param email the user email
 * @param password the user password
 * @param roles the user roles
 */
	public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
/**
 * Getter method for user id
 * @return the user id
 */
	public Long getId() {
		return id;
	}
	
/**
 * Setter method for user id
 * @param id the user id
 */
	public void setId(Long id) {
		this.id = id;
	}
	
/**
 * Getter method for user firstName
 * @return user first name
 */
	public String getFirstName() {
		return firstName;
	}
	
/**
 * Setter method for user firstName
 * @param firstName user first name
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
/**
 * Getter method for user lastName
 * @return user last name
 */
	public String getLastName() {
		return lastName;
	}
	
/**
 * Setter method for user lastName
 * @param lastName user last name
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

/**
 * Getter method for user email
 * @return user email
 */
	public String getEmail() {
		return email;
	}
	
/**
 * Setter method for user email
 * @param email user email
 */
	public void setEmail(String email) {
		this.email = email;
	}
	
/**
 * Getter method for user password
 * @return user password
 */
	public String getPassword() {
		return password;
	}
	
/**
 * Setter method for user password
 * @param password user password
 */
	public void setPassword(String password) {
		this.password = password;
	}
	
/**
 * Getter method for user collection of roles
 * @return collection of roles
 */
	public Collection<Role> getRoles() {
		return roles;
	}
	
/**
 * Setter method for user roles
 * @param roles collection of roles
 */
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

/**
 * Getter method for user class period
 * @return class period
 */
	public String getPeriod() {
		return period;
	}

/**
 * Setter method for user class period
 * @param period class period
 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
/**
 * To string method for User objects
 */
	@Override
	public String toString() {
		return "User [name=" + firstName + ", period=" + period + "]";
	}

}
