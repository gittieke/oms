package be.jslm;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import be.jslm.domain.Customer;
import be.jslm.domain.Order;
import be.jslm.repository.OrderRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

		// save a couple of order with their related customer
		Customer cust1 = new Customer("Jonas", "Devries");
		Set ordersAsCust1 = new HashSet<Order>() {
			{
				add(new Order(cust1));
				add(new Order(cust1));
				add(new Order(cust1));
			}
		};
		cust1.setOrders(ordersAsCust1);

		Customer cust2 = new Customer("Leentje", "Berghmans");
		Set ordersAsCust2 = new HashSet<Order>() {
			{
				add(new Order(cust1));
				add(new Order(cust1));
				add(new Order(cust1));
			}
		};
		cust2.setOrders(ordersAsCust2);

		orderRepository.save(ordersAsCust1);
		orderRepository.save(ordersAsCust2);

		// fetch all customers
		for (Order order : orderRepository.findAll()) {
			logger.info(order.toString());
		}

	}
}
