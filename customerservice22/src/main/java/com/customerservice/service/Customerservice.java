package com.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerservice.model.Customer;
import com.customerservice.repository.CustomerRepository;
@Service
public class Customerservice {
	@Autowired
	CustomerRepository customerRepository;

	public Customer postcustomer(Customer customer) {
		Customer cust=customerRepository.save(customer);
		return cust;
	}

	public List<Customer> getallcustomer() {
		List<Customer> list=customerRepository.findAll();
		return list;
	}

	public Optional<Customer> getByIdcustomer(String customerId) {
	Optional<Customer> cust=customerRepository.findById(customerId);
		return cust;
	}

	public Customer updatecustomer(Customer customer, String customerId) {
		Optional<Customer> cust=customerRepository.findById(customerId);
	Customer customer1=cust.get();
	customer1.setCustomerId(customer.getCustomerId());
	customer1.setAddress(customer.getAddress());
	customer1.setCustomerName(customer.getCustomerName());
	customer1.setDob(customer.getDob());
	customer1.setEmailID(customer.getEmailID());
	customer1.setPan(customer.getPan());
	customer1.setPhoneNumber(customer.getPhoneNumber());
	customer1.setTradeAccountNo(customer.getTradeAccountNo());
	customerRepository.save(customer1);
		return customer1;
	}

	public void deletebyId(String customerId) {
		customerRepository.deleteById(customerId);
		
	}

}
