package com.in28Minutes.learning.restfulWebService.restfulwebservice.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name= "user")
public class UserEntity {
	
	@Id
	private Integer id;
	
	 private String username;
	 
	 private String password;
	 
	// private Date dateCreated;
	 
	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinTable(name = "user_authority",
	            joinColumns = { @JoinColumn(name = "user_id") },
	            inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	    private Set<Authority> authorities = new HashSet<>();

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
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public Date getDateCreated() {
//		return dateCreated;
//	}
//
//	public void setDateCreated(Date dateCreated) {
//		this.dateCreated = dateCreated;
//	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public UserEntity() {
		super();
	}
	 
	 

}
