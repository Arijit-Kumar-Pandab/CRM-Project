package com.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.test.model.Customer;
import com.test.service.ICustomerService;

@Controller
@RequestMapping("/customer")
@EnableWebMvc
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/list")
	public String listCustomers(Map<String, Object> model) {
		System.out.println("Implementation class :: " + service.getClass().getName());

		List<Customer> customers = service.getCustomers();
		customers.forEach(System.out::println);

		model.put("customers", customers);

		return "list-customers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Map<String, Object> model) {
		System.out.println("CustomerController.showFormForAdd()");
		Customer customer = new Customer();
		model.put("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println("CustomerController.saveCustomer()");
		System.out.println(customer);
		service.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormUpdate")
	public String showFormForUpdate(@RequestParam Integer customerId, Map<String, Object> model) {
		Customer customer = service.getCustomer(customerId);
		model.put("customer", customer);
		return "customer-form";
	}

	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam Integer customerId) {
		service.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
}
