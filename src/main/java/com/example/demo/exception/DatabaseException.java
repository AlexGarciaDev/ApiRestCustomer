package com.example.demo.exception;

@SuppressWarnings("serial")
public class DatabaseException extends Exception {
	private String type;
	private String title;
	private String code;
    
    public DatabaseException(String type,String code,String message,String title) {
        super(message);
        this.code = code;
        this.title = title;
        this.type = type;
    }
    
    public DatabaseException(String type,String code,String message, Throwable cause, String title) {
        super(message, cause);
        this.code = code;
        this.title = title;
        this.type = type;
    }

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}
	
	public String getType() {
		return type;
	}
}