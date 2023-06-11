package com.example.demo.exception;

public class StandarizeApiExceptionResponse {
	private String type;
	private String title;
	private String code;
	private String detail;
	
	
	public StandarizeApiExceptionResponse(String type,String title, String code, String detail) {
		super();
		this.type = type;
		this.title = title;
		this.code = code;
		this.detail = detail;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}	
}
