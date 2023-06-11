package com.example.demo.api;

import java.util.logging.Logger;


public class ApiProduct extends Api{

	private Logger logger = Logger.getLogger(ApiProduct.class.getName());
	
	public ApiProduct() {
		setApiUrl("http://localhost:8002");
	}
	
	/* METHOD */
	public void setGetId(String id) {
		setPath("/product/"+id);
	}
	
	public void setGet() {
		setPath("/product");
	}
}
