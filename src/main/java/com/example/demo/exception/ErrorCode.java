package com.example.demo.exception;

public enum ErrorCode {

	GENERIC_ERROR("100","Generic exception has occurred"),
	DATABASE_TABLE("201","The connection to the database failed"),
	REST_QUERY("201","Custom query"),
	FIND("001","Find registers"),
	REST_CREATE("301","Create a registrer"),
	REST_UPDATE("302","Update a registrer"),
	REST_DELETE("303","Delete a registrer"),
	REST_VALIDATIONS("304","Validations"),
	REPORT("305","Report"),
	ACCESS_DENIED("400","Access denied");
	
	private final String _code;
	private final String _title;

	ErrorCode(String code, String title) {
		this._code = code;
	    this._title = title;
	}

	public String get_code() {return _code;}

	public String get_title() {return _title;}
}
