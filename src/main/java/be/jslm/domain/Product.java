package be.jslm.domain;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	private String productId;
	private String productName;
	
	protected Product(){}
	
	public Product(String productName){ 
		this.productId = String.format("PID-%d", new Random().nextLong());
		this.productName = productName;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Override
	public String toString() {		
		return String.format("Product[id=%d, productId='%s', productName='%s']", id, productId, productName);
	}

}
