package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_product")
public class CustomerProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="product_id")
	private String productId;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Customer.class)
	@JoinColumn(name ="customer_Id", nullable=true)
	private Customer customer;
	
	@Transient
	private String productName;
	
	public CustomerProduct() {
		super();
	}
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getProductId() {return productId;}
	public void setProductId(String productId) {this.productId = productId;}
	public Customer getCustomer() {return customer;}
	public void setCustomer(Customer customer) {this.customer = customer;}
	public String getProductName() {return productName;}
	public void setProductName(String productName) {this.productName = productName;}
	
}