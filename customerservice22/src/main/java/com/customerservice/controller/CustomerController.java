package com.customerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.model.Customer;
import com.customerservice.service.Customerservice;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	Customerservice customerservice;
	
	@PostMapping("/post")
	private ResponseEntity<Customer>postcustomer (@RequestBody Customer customer){
		Customer customer1=customerservice.postcustomer(customer);
		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	private ResponseEntity<List<Customer>>getallcustomer(){
		List<Customer> cust=customerservice.getallcustomer();
		return new ResponseEntity<List<Customer>>(cust, HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{customerId}")
	private ResponseEntity<Customer> getByIdcustomer(@PathVariable String customerId){
	Optional<Customer> cust=customerservice.getByIdcustomer(customerId);
	Customer cust1=cust.get();
	return new ResponseEntity<Customer>(cust1,HttpStatus.OK);
	}
	
	@PutMapping("/put/{customerId}")
	private ResponseEntity<Customer> updatecustomer(@PathVariable String customerId,@RequestBody Customer customer){
		Customer  customer1=customerservice.updatecustomer(customer,customerId);
		return new ResponseEntity<Customer>(customer1,HttpStatus.OK);
		
	}
	@DeleteMapping("/del/{customerId}")
	private ResponseEntity<String> deletebyId(@PathVariable String customerId){
		customerservice.deletebyId(customerId);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
		
	}
	
	
	

}
