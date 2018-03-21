package com.lqpl66.bean;

import java.io.Serializable;

public class User implements  Serializable {
	/**
	 *@description 
	 *@param
	 * @return 
	*/
	private static final long serialVersionUID = 1L;
	/**
	 *@description 
	 *@param
	 * @return 
	*/
	private Integer id;
	private String username;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}