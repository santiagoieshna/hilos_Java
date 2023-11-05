package service;

import java.util.HashSet;
import java.util.Set;

import model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private Set<Customer> customers;
	
	public CustomerServiceImpl() {
		super();
		this.customers = new HashSet<>();
	}

	@Override
	public Customer save(Long id, String name) {
		var customer = new Customer(id, name); // porque var ? estupido no ? 
        customers.add(customer);
        return customer;
	}
	
	@Override
	public Customer findById(Long Id) {
		
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			throw new RuntimeException(e);  // Porque siempre lanzamos este error ? 
		}
		
		return customers.stream()
				.filter(customer-> customer.id().equals(Id))
				.findFirst()
				.orElseThrow(); // hacer pruebas de orElseThrow, para como actua
	}

	@Override
	public Set<Customer> findAll() {
		   try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        if (!this.customers.isEmpty()) {
	            return this.customers;
	        }
	        throw new RuntimeException("No customer found");
	}

}
