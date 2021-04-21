package com.f3pro.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String messege;
	private String details;
	public ExceptionResponse(Date timestamp, String messege, String details) {
		super();
		this.timestamp = timestamp;
		this.messege = messege;
		this.details = details;
	}
	
	public String getDetails() {
		return details;
	}
	
	public String getMessege() {
		return messege;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

}
