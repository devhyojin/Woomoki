package com.example.ssafypjt2.model;


public class ResponseData {
	private String message;
	private Object data;
	
	public ResponseData(final String message, final Object data) {
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}