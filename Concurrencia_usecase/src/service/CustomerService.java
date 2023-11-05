package service;

import java.util.Set;

import model.Customer;

public interface CustomerService {
	Customer save(Long id, String name);
	Customer findById(Long Id);
	Set<Customer> findAll();
}
