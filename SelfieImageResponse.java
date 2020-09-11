package com.example.crifdemo.bean;

import java.io.Serializable;

public class SelfieImageResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private String selfiImageString;
	private double livenessScore;
	private String toBeReviewed;
	private String live;
	
	private String message;
	private int statusCode;
	public String getSelfiImageString() {
		return selfiImageString;
	}
	public void setSelfiImageString(String selfiImageString) {
		this.selfiImageString = selfiImageString;
	}
	public double getLivenessScore() {
		return livenessScore;
	}
	public void setLivenessScore(double livenessScore) {
		this.livenessScore = livenessScore;
	}
	public String getToBeReviewed() {
		return toBeReviewed;
	}
	public void setToBeReviewed(String toBeReviewed) {
		this.toBeReviewed = toBeReviewed;
	}
	public String getLive() {
		return live;
	}
	public void setLive(String live) {
		this.live = live;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "SelfieImageResponse [selfiImageString=" + selfiImageString + ", livenessScore=" + livenessScore
				+ ", toBeReviewed=" + toBeReviewed + ", live=" + live + ", message=" + message + ", statusCode="
				+ statusCode + "]";
	}
	
}
