package com.example.crifdemo.bean;

import java.io.Serializable;

public class ExternalSelfieRequestDetails implements Serializable{
private static final long serialVersionUID = 1L;
	
	private String url;
	private String request;
	private String status;
	private String exception;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	@Override
	public String toString() {
		return "ExternalSelfieRequestDetails [url=" + url + ", request=" + request + ", status=" + status
				+ ", exception=" + exception + "]";
	}
}
