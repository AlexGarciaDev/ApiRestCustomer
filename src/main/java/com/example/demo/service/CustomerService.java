package com.example.demo.service;


import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.api.ApiProduct;
import com.example.demo.entities.Customer;
import com.example.demo.entities.CustomerProduct;
import com.example.demo.exception.DatabaseException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	private Logger logger = Logger.getLogger(CustomerService.class.getName());
	@Autowired
	private CustomerRepository customerRepository;
	private ApiProduct product;
	private final WebClient.Builder webclientBuilder;
	private CustomerService (WebClient.Builder webclientBuilder) {this.webclientBuilder = webclientBuilder;}
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	public Customer findById(Long id) throws Exception {
		
		Customer customer;
			
		customer = customerRepository.findById(id).orElse(null);
		
		if(customer!=null) {
			List<CustomerProduct> products = customer.getProducts();
			products.forEach(x->{
				x.setProductName(getProductById(x.getProductId()));
			});
		}else {
			
			throw new DatabaseException(ErrorCode.FIND.get_title(),ErrorCode.FIND.get_code(),"El Cliente buscado no existe",Customer.class.getSimpleName());
		}

        
        return customer;
	}
	
	public Customer createCustomer(Customer input) {
		input.getProducts().forEach(x ->x.setCustomer(input));
        return customerRepository.save(input);
	}
	
	public Customer updateCustomer(Long id, Customer input) {
		Customer save = customerRepository.save(input);
		return customerRepository.save(save);
	}
	
	public ResponseEntity<?> deleteCustomer(Long id) {
		Optional<Customer> findBydId = customerRepository.findById(id);
    	
    	if(!findBydId.isEmpty()) {
    		customerRepository.delete(findBydId.get());
    		return ResponseEntity.ok().build();
    	}else {
    		return ResponseEntity.notFound().build();
    	}
	}
	
	
	/* APIS */
	private String getProductById(String id) {
		product = new ApiProduct();
		product.setWebclientBuilder(webclientBuilder);
        product.setGetId(id);
        product.initGet();
        
        return product.getValueResponse();
	}
	
}
