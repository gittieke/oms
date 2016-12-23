package be.jslm.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DomainTests {
	
	private static final Logger logger = LoggerFactory.getLogger(DomainTests.class);

	@Test
	public void testCustomerPojo() {
		Customer customer = new Customer("first", "last");	
		assertNotNull("should not be null", customer);		
		assertNull("no init from JPA at this level", customer.getId());
		assertEquals("should be equal", "CID-", customer.getCustomerId().substring(0, 4));			
		customer.getFirstName().equals("first");
		customer.getFirstName().equals("last");			
		
		logger.info(customer.toString());
	}
	
	@Test
	public void testProductPojo() {
		Product product = new Product("Rode kool");		
		assertNotNull("should not be null", product);				
		assertNull("no init from JPA at this level", product.getId());
		assertEquals("should be equal", "PID-", product.getProductId().substring(0, 4));			
		product.getProductName().equals("Rode kool");
		
		logger.info(product.toString());
	}	
	
	@Test
	public void testOrderPojo() {
		
		Customer customer = new Customer("first", "last");		
		Order order = new Order(customer);
		assertNotNull("order should not be null right after init", order);
		assertNull("no init from JPA at this level", order.getId());		
		assertEquals("should be equal", "OID-", order.getOrderId().substring(0, 4));			
		assertEquals("A new order has an ENTERED status", Order.Status.ENTERED, order.getOrderStatus());		
		assertNotNull("an order has a linked customer", order.getCustomer());
									
		// TODO: how to check on Date?
		//assertTrue("Init of order date should is before current timestamp",new Date().before(order.getOrderDate()));
		logger.info(String.format("Timestamp in millis=%d", Calendar.getInstance().getTimeInMillis()));
		logger.info(String.format("Order date in millis=%d", order.getOrderDate().getTime()));
		
		
		logger.info(order.toString());
	}
		
}
