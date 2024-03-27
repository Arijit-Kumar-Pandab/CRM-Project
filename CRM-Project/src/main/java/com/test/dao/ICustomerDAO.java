package com.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.model.Customer;

public interface ICustomerDAO extends CrudRepository<Customer, Integer> {

}
