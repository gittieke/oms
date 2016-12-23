package be.jslm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.jslm.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}