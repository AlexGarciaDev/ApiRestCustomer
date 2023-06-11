package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.demo.entities.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>, 
PagingAndSortingRepository<Customer, Long>, 
JpaSpecificationExecutor<Customer>, 
JpaRepository<Customer, Long>{

}
