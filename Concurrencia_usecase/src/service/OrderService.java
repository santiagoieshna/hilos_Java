package service;

import java.util.List;

import model.Order;

public interface OrderService {
	List<Order> findAll();

	List<Order> findAllByCustomerId(Long customerId);

	Order save(Long customerId, Long productId);
}
