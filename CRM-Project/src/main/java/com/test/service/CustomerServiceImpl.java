package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ICustomerDAO;
import com.test.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDAO repo;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) repo.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		repo.save(customer);
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> optional = repo.findById(customerId);
		return optional.get();
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		repo.deleteById(customerId);
	}

}
