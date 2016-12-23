package be.jslm.domain;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String orderId;
	private Date orderDate;
	private Enum<Status> orderStatus;
	private Customer customer;
		
	public enum Status {
	    ENTERED, PACKED, SEND 
	}
	
	protected Order(){};
	
	public Order(Customer customer){		
		this.orderId = String.format("OID-%d", new Random().nextLong());
		this.orderDate = new Date();
		this.orderStatus = Status.ENTERED;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Enum<Status> getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Enum<Status> orderStatus) {
		this.orderStatus = orderStatus;
	}

	@ManyToOne
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {		
		return String.format("Order[id=%d, orderId='%s', orderDate='%s',"
				+ " orderStatus='%s', customer='%s']", id, orderId, orderDate, 
				orderStatus, customer.toString());
	}
}
