package be.jslm.domain;

import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	private String customerId;
	private String firstName;
	private String lastName;
	private Set<Order> orders;
	
	protected Customer(){}

	public Customer(String firstName, String lastName) {
		this.customerId = String.format("CID-%d", new Random().nextLong());
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
		
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, customerId='%s', firstName='%s', lastName='%s']", 
				id, customerId, firstName, lastName);
		//TODO: add the orders
	}	
}
