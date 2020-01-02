package com.involves.audit.services.customer;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerDTO {
	
	private String name;
	private String login;
	private String password;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	
	private Integer profileId;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Integer getProfileId() {
		return profileId;
	}
	
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
}
