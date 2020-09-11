package com.example.crifdemo.dao;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;
import org.springframework.lang.NonNull;
@Entity

@Table(name = "json_users")
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String username;

	@NonNull
	//@Column(columnDefinition = "jsonb")
	@Convert(converter = JSONObjectConverter.class)
	private JSONObject jsonData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	
	
}
