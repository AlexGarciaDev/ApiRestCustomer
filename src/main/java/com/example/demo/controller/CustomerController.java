package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.entities.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) 
	{
		super();
		this.customerService = customerService;
	}

	@GetMapping
    public ResponseEntity< List<Customer> > findAll() {
		
		List<Customer> customer = customerService.findAll();
		
		if(customer.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(customer);
		}
    }

    @GetMapping("/{id}")
    public ResponseEntity< Customer> findById(@PathVariable Long id) throws Exception {
    	Customer customer = customerService.findById(id);
    	
    	if(customer==null) {
    		return ResponseEntity.noContent().build();
    	}else {
    		return ResponseEntity.ok(customer);
    	}
    	
    }
    
    @GetMapping("list/{id}")
    public Customer findById2(@PathVariable Long id) throws Exception {
    	Customer customer = customerService.findById(id);
    	
    	return customer;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer input) {
    	Customer customer = customerService.createCustomer(input);
    	
    	return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Customer input) {
    	return ResponseEntity.ok(customerService.updateCustomer(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
    	return customerService.deleteCustomer(id);
    }
}
