package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import model.Order;

public class OrderServiceImpl implements OrderService {

	private final Map<Long, Order> orders;
	
	public OrderServiceImpl() {
		super();
		this.orders = new HashMap<Long, Order>();
	}

	@Override
	public List<Order> findAll() {
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException();
			}
		return orders.keySet().stream()
				.map(orders::get)
				.toList();
	}

	@Override
	public List<Order> findAllByCustomerId(Long customerId) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
		return orders.keySet().stream()
				.filter(id-> Objects.equals(id, customerId))
				.map(orders::get)
				.collect(Collectors.toList());
	}

	@Override
	public Order save(Long customerId, Long productId) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
		Order order = new Order(customerId, productId);
		orders.put(productId, order);
		return order;
	}

}
