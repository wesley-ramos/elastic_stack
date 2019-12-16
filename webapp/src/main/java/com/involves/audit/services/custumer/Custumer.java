package com.involves.audit.services.custumer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Custumer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String name;
	private Date birthday;
	private Integer profileId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
